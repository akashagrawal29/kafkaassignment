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
@Table(name = "Service")
public class Service {
    @Id
    String CASE_NUMBER;
    String SVC_ID;
    String SVC_TYPE;
    String SVC_CODE;
    String SVC_FAC_ID;
    String SVC_FAC_NAME;
    String SVC_PHY_ID;
    String SVC_PHY_NAME;
    String SOURCE;
}
