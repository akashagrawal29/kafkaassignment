package com.demo.kafka.kafkaassignment.service.impl;


import com.demo.kafka.kafkaassignment.service.KafkaProducer;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.PreDestroy;

@Service
public class DemoKafkaProducer implements KafkaProducer<String, String> {
    private static final Logger LOG = LoggerFactory.getLogger(DemoKafkaProducer.class);

    @Autowired
    @Qualifier("customKafkaTemplate")
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String topicName, String key, String message) {
        LOG.debug("Sending message='{}' to topic={}", message, topicName);
        LOG.info("kafkaTemplate: {}",kafkaTemplate);
        ListenableFuture<SendResult<String, String>> listenableFuture = kafkaTemplate.send(topicName, key, message);
        addCallBack(topicName, message, listenableFuture);
    }

    @PreDestroy
    public void close(){
        if(kafkaTemplate != null){
            LOG.info("Closing kafka producer");
            kafkaTemplate.destroy();
        }
    }

    private void addCallBack(String topicName, String message, ListenableFuture<SendResult<String, String>> listenableFuture) {
        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                LOG.error("Error while sending message '{}' to topic={}", message, topicName);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                RecordMetadata metaData = result.getRecordMetadata();
                LOG.info("Received new metadata. Topic={}, partition={}, offset={}, timestamp={}, at time={}",
                        metaData.topic(), metaData.partition(), metaData.offset(), metaData.timestamp(), System.nanoTime());
            }
        });
    }
}
