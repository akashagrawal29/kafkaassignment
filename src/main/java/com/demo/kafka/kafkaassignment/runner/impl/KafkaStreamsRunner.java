package com.demo.kafka.kafkaassignment.runner.impl;

import com.demo.kafka.kafkaassignment.config.KafkaConfig;
import com.demo.kafka.kafkaassignment.config.KafkaStreamsConfigData;
import com.demo.kafka.kafkaassignment.dto.*;
import com.demo.kafka.kafkaassignment.runner.StreamRunner;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
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
    private final Properties streamsConfiguration;
    private Map<String, String> serdeConfig;
    private static final String SUBSCRIBER = "subscriber";
    private static final String MYCASE = "mycase";
    private static final String PATIENT = "patient";
    private static final String SERVICE = "service";
    private static final String SOURCE_VALUE_BY_CODE = "KSTREAMS";
    private Serde<OutputAvroModel> outputSerde;

    public KafkaStreamsRunner(KafkaStreamsConfigData kafkaStreamsConfigData, KafkaConfig kafkaConfig) {
        this.kafkaStreamsConfigData = kafkaStreamsConfigData;
        this.kafkaConfig = kafkaConfig;
        streamsConfiguration = new Properties();
        putSerdeConfigs();
        createSerde();
        streamsConfiguration();
    }

    public void putSerdeConfigs() {
        serdeConfig = new HashMap<>();
        serdeConfig.put(kafkaConfig.getSchemaRegistryUrlKey(), kafkaConfig.getSchemaRegistryUrl());
    }

    private void createSerde() {
        outputSerde = new SpecificAvroSerde<>();
        outputSerde.configure(serdeConfig, false);
    }

    public void streamsConfiguration() {
        streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, kafkaStreamsConfigData.getApplicationID());
        streamsConfiguration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConfig.getBootstrapServers());
        streamsConfiguration.put(kafkaConfig.getSchemaRegistryUrlKey(), kafkaConfig.getSchemaRegistryUrl());
        streamsConfiguration.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        streamsConfiguration.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
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
        KStream<String, OutputAvroModel> kStream = builder.stream(inputTopic,
                Consumed.with(Serdes.String(), outputSerde));
        kStream.mapValues(val -> {
            Subscriber subs = val.getSubscriber();
            subs.setMysource(SOURCE_VALUE_BY_CODE);
            return subs;
        }).to(SUBSCRIBER,
                Produced.with(Serdes.String(), getSubscriberSerde()));
        kStream.mapValues(val -> {
            Mycase mycase = val.getMycase();
            mycase.setMysource(SOURCE_VALUE_BY_CODE);
            return mycase;
        }).to(MYCASE, Produced.with(Serdes.String(), getMycaseSerde()));
        kStream.mapValues(val -> {
            Patient patient = val.getPatient();
            patient.setMysource(SOURCE_VALUE_BY_CODE);
            return patient;
        }).to(PATIENT, Produced.with(Serdes.String(), getPatientSerde()));
        kStream.mapValues(val -> {
            Service service = val.getService();
            service.setMysource(SOURCE_VALUE_BY_CODE);
            return service;
        }).to(SERVICE, Produced.with(Serdes.String(), getServiceSerde()));
        return builder.build();
    }

    private Serde<Service> getServiceSerde() {
        Serde<Service> serviceSerde = new SpecificAvroSerde<>();
        serviceSerde.configure(serdeConfig, false);
        return serviceSerde;
    }

    private Serde<Patient> getPatientSerde() {
        Serde<Patient> patientSerde = new SpecificAvroSerde<>();
        patientSerde.configure(serdeConfig, false);
        return patientSerde;
    }

    private Serde<Mycase> getMycaseSerde() {
        Serde<Mycase> caseSerde = new SpecificAvroSerde<>();
        caseSerde.configure(serdeConfig, false);
        return caseSerde;
    }

    private Serde<Subscriber> getSubscriberSerde() {
        Serde<Subscriber> subscriberSerde = new SpecificAvroSerde<>();
        subscriberSerde.configure(serdeConfig, false);
        return subscriberSerde;
    }
}
