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
public class Service {
    String CASE_NUMBER;
    String SVC_ID;
    String SVC_TYPE;
    String SVC_CODE;
    String SVC_FAC_ID;
    String SVC_FAC_NAME;
    String SVC_PHY_ID;
    String SVC_PHY_NAME;
}
