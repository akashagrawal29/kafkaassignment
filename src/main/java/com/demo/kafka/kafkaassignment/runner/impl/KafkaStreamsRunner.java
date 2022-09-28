package com.demo.kafka.kafkaassignment.runner.impl;

import com.demo.kafka.kafkaassignment.config.KafkaConfig;
import com.demo.kafka.kafkaassignment.config.KafkaStreamsConfigData;
import com.demo.kafka.kafkaassignment.runner.StreamRunner;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    private List<KafkaStreams> kafkaStreamsList;
    private List<CountDownLatch> latchList;

    public KafkaStreamsRunner(KafkaStreamsConfigData kafkaStreamsConfigData, KafkaConfig kafkaConfig) {
        this.kafkaStreamsConfigData = kafkaStreamsConfigData;
        this.kafkaConfig = kafkaConfig;
        kafkaStreamsList = new ArrayList<>();
        latchList = new ArrayList<>();
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
            LOG.info("val is{}", val);
            JsonNode json = null;
            try {
                json = mapper.readTree(val);
            } catch (JsonProcessingException e) {
                LOG.warn("Exception while converting to JsonNode: ", e);
                return null;
            }
            String str = json.get(outputTopicName).toString();
            LOG.info("For outputTopicName {} String is : {}", outputTopicName, str);
            return str;
        });
    }

    @Override
    public void start() {
        try {
            LOG.debug("Calling kafkaStreams start");
            Properties properties = streamsConfiguration();
            KafkaStreams kafkaStreams = new KafkaStreams(buildTopology(), properties);
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
            try {
                latch.await();
            } catch (InterruptedException e) {
                LOG.warn("Exception during await: ", e);
                Thread.currentThread().interrupt();
            }
        } catch (Exception e) {
            LOG.warn("Exception in kafka streams: ", e);
        }
    }

//    @PreDestroy
//    public void close() {
//        if (kafkaStreams != null) {
//
//            LOG.info("Kafka streaming closed!");
//        }
//    }

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
