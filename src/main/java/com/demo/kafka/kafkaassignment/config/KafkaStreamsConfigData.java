package com.demo.kafka.kafkaassignment.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "kafka-streams-config")
public class KafkaStreamsConfigData {
    private String applicationID;
    private String inputTopicName;
    private List<String> outputTopicNames;
}
