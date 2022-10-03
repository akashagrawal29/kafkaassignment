package com.demo.kafka.kafkaassignment.runner.impl;

import com.demo.kafka.kafkaassignment.config.KafkaConfig;
import com.demo.kafka.kafkaassignment.config.KafkaStreamsConfigData;
import com.demo.kafka.kafkaassignment.models.Case;
import com.demo.kafka.kafkaassignment.models.Patient;
import com.demo.kafka.kafkaassignment.models.Service;
import com.demo.kafka.kafkaassignment.models.Subscriber;
import com.demo.kafka.kafkaassignment.runner.StreamRunner;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.confluent.kafka.schemaregistry.client.CachedSchemaRegistryClient;
import io.confluent.kafka.schemaregistry.client.SchemaRegistryClient;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.streams.serdes.json.KafkaJsonSchemaSerde;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.kstream.ValueMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.CountDownLatch;

@Component
public class KafkaStreamsRunner implements StreamRunner {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaStreamsRunner.class);
    private final KafkaStreamsConfigData kafkaStreamsConfigData;
    private final KafkaConfig kafkaConfig;
    private final SchemaRegistryClient schemaRegistryClient;
    private final Properties streamsConfiguration;
    private final Map<String, Object> serdeConfig;
    private static final String SUBSCRIBER = "subscriber";
    private static final String MYCASE = "mycase";
    private static final String PATIENT = "patient";
    private static final String SERVICE = "service";
    private static final String LOG_TYPE = "node is {}";
    public KafkaStreamsRunner(KafkaStreamsConfigData kafkaStreamsConfigData, KafkaConfig kafkaConfig) {
        this.kafkaStreamsConfigData = kafkaStreamsConfigData;
        this.kafkaConfig = kafkaConfig;
        serdeConfig = new HashMap<>();
        streamsConfiguration = new Properties();
        schemaRegistryClient = new CachedSchemaRegistryClient(kafkaConfig.getSchemaRegistryUrl(), 10);
        putSerdeConfigs();
        streamsConfiguration();
    }

    public void createTopics(Properties allProps) {
        AdminClient client = AdminClient.create(allProps);

        List<NewTopic> topics = new ArrayList<>();
        topics.add(new NewTopic(kafkaStreamsConfigData.getInputTopicName(), 1, (short) 1));
        for (String outputTopicName : kafkaStreamsConfigData.getOutputTopicNames()) {
            topics.add(new NewTopic(outputTopicName, 1, (short) 1));
        }
        client.createTopics(topics);
        client.close();
    }

    public Topology buildTopology() {
        final StreamsBuilder builder = new StreamsBuilder();
        final String inputTopic = kafkaConfig.getTopicName();
        var kStream = builder.stream(inputTopic, Consumed.with(Serdes.String(), Serdes.String()));
        Serde<Subscriber> subscriberSerde = new KafkaJsonSchemaSerde<>(schemaRegistryClient, Subscriber.class);
        subscriberSerde.configure(serdeConfig, false);
        Serde<Case> caseSerde = new KafkaJsonSchemaSerde<>(schemaRegistryClient, Case.class);
        caseSerde.configure(serdeConfig, false);
        Serde<Patient> patientSerde = new KafkaJsonSchemaSerde<>(schemaRegistryClient, Patient.class);
        patientSerde.configure(serdeConfig, false);
        Serde<Service> serviceSerde = new KafkaJsonSchemaSerde<>(schemaRegistryClient, Service.class);
        serviceSerde.configure(serdeConfig, false);
        kStream.mapValues(valueMapper(SUBSCRIBER)).mapValues(subscriberValueMapper()).to(
                SUBSCRIBER, Produced.with(Serdes.String(), subscriberSerde));
        kStream.mapValues(valueMapper(MYCASE)).mapValues(myCaseValueMapper()).to(
                MYCASE, Produced.with(Serdes.String(), caseSerde));
        kStream.mapValues(valueMapper(PATIENT)).mapValues(patientValueMapper()).to(
                PATIENT, Produced.with(Serdes.String(), patientSerde));
        kStream.mapValues(valueMapper(SERVICE)).mapValues(serviceValueMapper()).to(
                SERVICE, Produced.with(Serdes.String(), serviceSerde));
        return builder.build();
    }

    private ValueMapper<String, ObjectNode> valueMapper(String outputTopicName) {
        final ObjectMapper mapper = new ObjectMapper();
        return (val -> {
            LOG.info("val is {}", val);
            val = val.replaceAll("[\\x00-\\x09\\x0B\\x0C\\x0E-\\x1F\\x7F]", "");
            JsonNode topicJson;
            try {
                JsonNode json = mapper.readTree(val);
                topicJson = json.get(outputTopicName);
            } catch (JsonProcessingException e) {
                LOG.warn("Exception while converting to json: ",e);
                return null;
            }
            ObjectNode objectNode = (ObjectNode) topicJson;
            objectNode = objectNode.put("mysource", "KSTREAMS");
            LOG.info("Sending to outputTopicName: {} with Message : {}", outputTopicName, objectNode);
            return objectNode;
        });
    }

    @Override
    public void start() {
        createTopics(streamsConfiguration);
        try (KafkaStreams kafkaStreams = new KafkaStreams(buildTopology(), streamsConfiguration)) {
            LOG.debug("Calling kafkaStreams start");
            CountDownLatch latch = new CountDownLatch(1);
            Runtime.getRuntime().addShutdownHook(new Thread("streams-shutdown-hook") {
                @Override
                public void run() {
                    LOG.info("Closing kafka streams");
                    kafkaStreams.close();
                    latch.countDown();
                }
            });
            kafkaStreams.start();
            latch.await();
        } catch (InterruptedException e) {
            LOG.warn("Exception during await: ", e);
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            LOG.warn("Exception in kafka streams: ", e);
        }
    }

    public void putSerdeConfigs(){
        serdeConfig.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, kafkaConfig.getSchemaRegistryUrl());
        serdeConfig.put(AbstractKafkaSchemaSerDeConfig.AUTO_REGISTER_SCHEMAS, true);
    }
    public void streamsConfiguration() {
        streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, kafkaStreamsConfigData.getApplicationID());
        streamsConfiguration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConfig.getBootstrapServers());
        streamsConfiguration.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        streamsConfiguration.put(ConsumerConfig.ALLOW_AUTO_CREATE_TOPICS_CONFIG, "true");
    }

    private ValueMapper<ObjectNode, Subscriber> subscriberValueMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        return (node -> {
            LOG.info(LOG_TYPE, node);
            Subscriber subscriberObj = null;
            try {
                subscriberObj = mapper.treeToValue(node, Subscriber.class);
            } catch (JsonProcessingException e) {
                LOG.warn("Exception while converting to subscriber: ",e);
            }
            LOG.info("Sending to outputTopicName: subscriber with Message : {}", subscriberObj);
            return subscriberObj;
        });
    }

    private ValueMapper<ObjectNode, Case> myCaseValueMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        return (node -> {
            LOG.info(LOG_TYPE, node);
            Case myCase = null;
            try {
                myCase = mapper.treeToValue(node, Case.class);
            } catch (JsonProcessingException e) {
                LOG.warn("Exception while converting to myCase: ",e);
            }
            LOG.info("Sending to outputTopicName: mycase with Message : {}", myCase);
            return myCase;
        });
    }

    private ValueMapper<ObjectNode, Patient> patientValueMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        return (node -> {
            LOG.info(LOG_TYPE, node);
            Patient patientObj = null;
            try {
                patientObj = mapper.treeToValue(node, Patient.class);
            } catch (JsonProcessingException e) {
                LOG.warn("Exception while converting to patient: ",e);
            }
            LOG.info("Sending to outputTopicName: patient with Message : {}", patientObj);
            return patientObj;
        });
    }

    private ValueMapper<ObjectNode, Service> serviceValueMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        return (node -> {
            LOG.info(LOG_TYPE, node);
            Service serviceObj = null;
            try {
                serviceObj = mapper.treeToValue(node, Service.class);
            } catch (JsonProcessingException e) {
                LOG.warn("Exception while converting to service: ",e);
            }
            LOG.info("Sending to outputTopicName: service with Message : {}", serviceObj);
            return serviceObj;
        });
    }
}
