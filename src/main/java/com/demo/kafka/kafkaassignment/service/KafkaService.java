package com.demo.kafka.kafkaassignment.service;

import com.demo.kafka.kafkaassignment.config.KafkaConfig;
import com.demo.kafka.kafkaassignment.dto.OutputAvroModel;
import com.demo.kafka.kafkaassignment.parser.Parser;
import com.demo.kafka.kafkaassignment.service.impl.DemoKafkaProducer;
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
    private static final String DIR = "/Users/akashagrawal29/Desktop/kafkaassignment/src/main/files";
    private static final Logger LOG = LoggerFactory.getLogger(KafkaService.class);

    private final KafkaConfig kafkaConfig;
    private final KafkaProducer<String, OutputAvroModel> kafkaProducer;
    private final Parser<OutputAvroModel> parser;

    public KafkaService(KafkaConfig kafkaConfig, DemoKafkaProducer kafkaProducer, Parser<OutputAvroModel> parser) {
        this.kafkaConfig = kafkaConfig;
        this.kafkaProducer = kafkaProducer;
        this.parser = parser;
    }

    public OutputAvroModel readFileAndUpdate() {
        try (Stream<Path> stream = Files.list(Paths.get(DIR))) {
            stream.forEach(file -> {
                if (!Files.isDirectory(file)) {
                    List<OutputAvroModel> list = parser.parse(file);
                    LOG.info("List is: {}", list);
                    sendDataTokafka(list);
                }
            });
        } catch (IOException e) {
            LOG.warn("Error while getting files from directory: ", e.getCause());
        }
        return null;
    }

    private void sendDataTokafka(List<OutputAvroModel> list) {
        String topic = kafkaConfig.getTopicName();
        for (OutputAvroModel message : list) {
            String key = message.getSubscriber().getCaseNUMBER();
            LOG.info("Sending to kafkatopic: {} with key: {} and message: {}", topic, key, message);
            kafkaProducer.send(topic, key, message);
        }
    }
}
