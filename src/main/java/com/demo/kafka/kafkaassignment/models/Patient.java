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
@Entity
@AllArgsConstructor
public class Patient implements Serializable {
    @Id
    String case_NUMBER;
    String pat_ID;
    String pat_FIRST_NAME;
    String pat_MIDDLE_NAME;
    String pat_LAST_NAME;
    String pat_SEX;
    String pat_DOB;
    String pat_PLANE_TYPE;
    String pat_PLAN_NAME;
    String mysource;
}
