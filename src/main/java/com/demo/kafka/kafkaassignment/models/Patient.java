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
@Table(name = "Patient")
public class Patient {
    @Id
    String CASE_NUMBER;
    String PAT_ID;
    String PAT_FIRST_NAME;
    String PAT_MIDDLE_NAME;
    String PAT_LAST_NAME;
    String PAT_SEX;
    String PAT_DOB;
    String PAT_PLANE_TYPE;
    String PAT_PLAN_NAME;
    String SOURCE;
}
