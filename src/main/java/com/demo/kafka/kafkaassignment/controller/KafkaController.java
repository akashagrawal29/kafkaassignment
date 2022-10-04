package com.demo.kafka.kafkaassignment.controller;

import com.demo.kafka.kafkaassignment.dto.OutputAvroModel;
import com.demo.kafka.kafkaassignment.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    KafkaService kafkaService;
    @GetMapping("/api/readFile")
    public OutputAvroModel readFileAndUpdate() {
        return kafkaService.readFileAndUpdate();
    }
}
