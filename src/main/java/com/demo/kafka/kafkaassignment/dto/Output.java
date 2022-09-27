package com.demo.kafka.kafkaassignment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Output {
    private Subscriber subscriber;
    private Patient patient;
    private Case mycase;
    private Service service;
}
