package com.demo.kafka.kafkaassignment.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "Subscriber")
public class Subscriber {
    @Id
    String CASE_NUMBER;
    String MEM_ID;
    String MEM_FIRST_NAME;
    String MEM_MIDDLE_NAME;
    String MEM_LAST_NAME;
    String MEM_ADD_1;
    String MEM_ADD_2;
    String MEM_CITY;
    String MEM_PIN;
    String SOURCE;
}
