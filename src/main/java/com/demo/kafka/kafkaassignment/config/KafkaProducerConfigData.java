package com.demo.kafka.kafkaassignment.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "kafka-producer-config")
public class KafkaProducerConfigData {

    private String keySerializerClass;
    private String valueSerializerClass;
    private String acks;
    private int batchSize;
    private int lingerMs;
    private int requestTimeoutMs;

}
