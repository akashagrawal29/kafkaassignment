package com.demo.kafka.kafkaassignment.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "Mycase")
public class Case implements Serializable {
    
    @Id
    String case_NUMBER;
    String case_TYPE;
    String case_CODE;
    String case_START_DATE;
    String case_END_DATE;
    String case_AUTH_TYPE;
    String case_STATUS;
    String mysource;
}
