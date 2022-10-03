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
public class Patient implements Serializable {
    @JsonProperty("case_NUMBER")
    String CASE_NUMBER;
    @JsonProperty("pat_ID")
    String PAT_ID;
    @JsonProperty("pat_FIRST_NAME")
    String PAT_FIRST_NAME;
    @JsonProperty("pat_MIDDLE_NAME")
    String PAT_MIDDLE_NAME;
    @JsonProperty("pat_LAST_NAME")
    String PAT_LAST_NAME;
    @JsonProperty("pat_SEX")
    String PAT_SEX;
    @JsonProperty("pat_DOB")
    String PAT_DOB;
    @JsonProperty("pat_PLANE_TYPE")
    String PAT_PLANE_TYPE;
    @JsonProperty("pat_PLAN_NAME")
    String PAT_PLAN_NAME;
    @JsonProperty("mysource")
    String MYSOURCE;
}
