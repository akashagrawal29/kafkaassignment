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
@Table(name = "myCase")
public class Case {
    @Id
    String CASE_NUMBER;
    String CASE_TYPE;
    String CASE_CODE;
    String CASE_START_DATE;
    String CASE_END_DATE;
    String CASE_AUTH_TYPE;
    String CASE_STATUS;
    String SOURCE;
}
