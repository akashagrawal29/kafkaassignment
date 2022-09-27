package com.demo.kafka.kafkaassignment.service;

import java.io.Serializable;

public interface KafkaProducer<K extends Serializable, V extends Serializable> {
    void send(String topicName, K key, V message);
}
