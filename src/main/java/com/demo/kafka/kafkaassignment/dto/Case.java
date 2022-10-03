package com.demo.kafka.kafkaassignment.dto;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Case {
    String CASE_NUMBER;
    String CASE_TYPE;
    String CASE_CODE;
    String CASE_START_DATE;
    String CASE_END_DATE;
    String CASE_AUTH_TYPE;
    String CASE_STATUS;
}
