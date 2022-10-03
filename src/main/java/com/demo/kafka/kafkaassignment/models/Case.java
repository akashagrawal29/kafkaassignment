package com.demo.kafka.kafkaassignment.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonSerializableSchema
public class Case implements Serializable {
    @JsonProperty("case_NUMBER")
    String CASE_NUMBER;
    @JsonProperty("case_TYPE")
    String CASE_TYPE;
    @JsonProperty("case_CODE")
    String CASE_CODE;
    @JsonProperty("case_START_DATE")
    String CASE_START_DATE;
    @JsonProperty("case_END_DATE")
    String CASE_END_DATE;
    @JsonProperty("case_AUTH_TYPE")
    String CASE_AUTH_TYPE;
    @JsonProperty("case_STATUS")
    String CASE_STATUS;
    @JsonProperty("mysource")
    String MYSOURCE;
}
