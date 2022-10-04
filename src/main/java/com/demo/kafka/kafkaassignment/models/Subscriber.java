package com.demo.kafka.kafkaassignment.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Subscriber implements Serializable {
    @Id
    String case_NUMBER;
    String mem_ID;
    String mem_FIRST_NAME;
    String mem_MIDDLE_NAME;
    String mem_LAST_NAME;
    String mem_ADD_1;
    String mem_ADD_2;
    String mem_CITY;
    String mem_PIN;
    String mysource;
}
