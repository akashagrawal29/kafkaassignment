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
public class Service implements Serializable {
    @JsonProperty("case_NUMBER")
    String CASE_NUMBER;
    @JsonProperty("svc_ID")
    String SVC_ID;
    @JsonProperty("svc_TYPE")
    String SVC_TYPE;
    @JsonProperty("svc_CODE")
    String SVC_CODE;
    @JsonProperty("svc_FAC_ID")
    String SVC_FAC_ID;
    @JsonProperty("svc_FAC_NAME")
    String SVC_FAC_NAME;
    @JsonProperty("svc_PHY_ID")
    String SVC_PHY_ID;
    @JsonProperty("svc_PHY_NAME")
    String SVC_PHY_NAME;
    @JsonProperty("mysource")
    String MYSOURCE;
}
