package com.demo.kafka.kafkaassignment.runner.impl;

import com.demo.kafka.kafkaassignment.config.KafkaConfig;
import com.demo.kafka.kafkaassignment.config.KafkaStreamsConfigData;
import com.demo.kafka.kafkaassignment.runner.StreamRunner;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

@Component
public class KafkaStreamsRunner implements StreamRunner {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaStreamsRunner.class);
    private final KafkaStreamsConfigData kafkaStreamsConfigData;
    private final KafkaConfig kafkaConfig;

    public KafkaStreamsRunner(KafkaStreamsConfigData kafkaStreamsConfigData, KafkaConfig kafkaConfig) {
        this.kafkaStreamsConfigData = kafkaStreamsConfigData;
        this.kafkaConfig = kafkaConfig;
    }

    public void createTopics(Properties allProps) {
        AdminClient client = AdminClient.create(allProps);

        List<NewTopic> topics = new ArrayList<>();
        topics.add(new NewTopic(kafkaStreamsConfigData.getInputTopicName(), 1, (short) 1));
        for(String outputTopicName : kafkaStreamsConfigData.getOutputTopicNames()){
            topics.add(new NewTopic(outputTopicName,1, (short) 1));
        }
        client.createTopics(topics);
        client.close();
    }

    public Topology buildTopology() {
        final StreamsBuilder builder = new StreamsBuilder();
        final String inputTopic = kafkaConfig.getTopicName();
        var kStream = builder.stream(inputTopic, Consumed.with(Serdes.String(), Serdes.String()));
        for (String outputTopicName : kafkaStreamsConfigData.getOutputTopicNames()) {
            kStream.mapValues(valueMapper(outputTopicName)).to(outputTopicName,
                    Produced.with(Serdes.String(), Serdes.String()));
        }
        return builder.build();
    }

    private ValueMapper<String, String> valueMapper(String outputTopicName) {
        ObjectMapper mapper = new ObjectMapper();
        return (val -> {
            LOG.debug("val is {}", val);
            JsonNode json;
            try {
                json = mapper.readTree(val);
            } catch (JsonProcessingException e) {
                LOG.warn("Exception while converting to JsonNode: ", e);
                return null;
            }
            JsonNode node = json.get(outputTopicName);
            ObjectNode obj = ((ObjectNode)node).put("mysource", "KSTREAMS");
            String str = obj.toString();
            LOG.info("For outputTopicName {} String is : {}", outputTopicName, str);
            return str;
        });
    }

    @Override
    public void start() {
        Properties properties = streamsConfiguration();
//        createTopics(properties);
        try(KafkaStreams kafkaStreams = new KafkaStreams(buildTopology(), properties)) {
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

    public Properties streamsConfiguration() {
        Properties streamsConfiguration = new Properties();
        streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, kafkaStreamsConfigData.getApplicationID());
        streamsConfiguration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConfig.getBootstrapServers());
        streamsConfiguration.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        streamsConfiguration.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        streamsConfiguration.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        streamsConfiguration.put(ConsumerConfig.ALLOW_AUTO_CREATE_TOPICS_CONFIG, "true");
        return streamsConfiguration;
    }
}
