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
public class Subscriber implements Serializable {
    @JsonProperty("case_NUMBER")
    String CASE_NUMBER;
    @JsonProperty("mem_ID")
    String MEM_ID;
    @JsonProperty("mem_FIRST_NAME")
    String MEM_FIRST_NAME;
    @JsonProperty("mem_MIDDLE_NAME")
    String MEM_MIDDLE_NAME;
    @JsonProperty("mem_LAST_NAME")
    String MEM_LAST_NAME;
    @JsonProperty("mem_ADD_1")
    String MEM_ADD_1;
    @JsonProperty("mem_ADD_2")
    String MEM_ADD_2;
    @JsonProperty("mem_CITY")
    String MEM_CITY;
    @JsonProperty("mem_PIN")
    String MEM_PIN;
    @JsonProperty("mysource")
    String MYSOURCE;
}
