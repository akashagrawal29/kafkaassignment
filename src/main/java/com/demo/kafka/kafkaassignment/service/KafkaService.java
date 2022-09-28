package com.demo.kafka.kafkaassignment.service;

import com.demo.kafka.kafkaassignment.config.KafkaConfig;
import com.demo.kafka.kafkaassignment.dto.Output;
import com.demo.kafka.kafkaassignment.parser.Parser;
import com.demo.kafka.kafkaassignment.service.impl.DemoKafkaProducer;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Service
public class KafkaService {
    private static final String DIR = "/Users/akashagrawal29/Desktop/KafkaAssignment/kafkaassignment/src/main/files";
    private static final Logger LOG = LoggerFactory.getLogger(KafkaService.class);

    private final KafkaConfig kafkaConfig;
    private final KafkaProducer kafkaProducer;
    private final Parser parser;

    public KafkaService(KafkaConfig kafkaConfig, DemoKafkaProducer kafkaProducer, Parser parser) {
        this.kafkaConfig = kafkaConfig;
        this.kafkaProducer = kafkaProducer;
        this.parser = parser;
    }

    public Output readFileAndUpdate() {
        try (Stream<Path> stream = Files.list(Paths.get(DIR));) {
            stream.forEach(file -> {
                if (!Files.isDirectory(file)) {
                    List<JsonNode> list = parser.parse(file);
                    sendDataTokafka(list);
                    LOG.info("List is: {}", list);
                }
            });
        } catch (IOException e) {
            LOG.warn("Error while getting files from directory: {}", e.getCause());
        }
        return null;
    }

    private void sendDataTokafka(List<JsonNode> list) {
        for (JsonNode li : list) {
            String topic = kafkaConfig.getTopicName();
            String key = li.get("subscriber").get("mem_ID").asText();
            String message = li.toString().replace("mycase", "case");
            LOG.info("sending to kafkatopic: {} with key: {} and message: {}", topic, key, message);
            kafkaProducer.send(topic, key, message);
        }
    }
}
