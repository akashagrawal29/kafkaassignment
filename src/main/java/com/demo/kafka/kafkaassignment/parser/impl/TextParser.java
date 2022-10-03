package com.demo.kafka.kafkaassignment.parser.impl;

import com.demo.kafka.kafkaassignment.dto.*;
import com.demo.kafka.kafkaassignment.enums.Mapping;
import com.demo.kafka.kafkaassignment.parser.Parser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TextParser implements Parser {

    private static final Logger LOG = LoggerFactory.getLogger(TextParser.class);

    @Override
    public List<Output> parse(Path file) {
        LOG.info("Parsing file: {}", file.getFileName());
        List<Output> list = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String st;
            Output output = new Output();
            int count = 0;
            while ((st = reader.readLine()) != null) {
                String mapped = "";
                if (st.length() > 3) {
                    mapped = st.substring(0, 3);
                }
                if (mapped.equals(Mapping.SUB.displayName())) {
                    count++;
                    if (count == 2) {
                        count = 1;
                        LOG.debug("Output is: {}", output);
                        list.add(output);
                        output = new Output();
                    }
                    output.setSubscriber(getSubscriber(st));
                } else if (mapped.equals(Mapping.CAS.displayName())) {
                    output.setMycase(getCase(st));
                } else if (mapped.equals(Mapping.PAT.displayName())) {
                    output.setPatient(getPatient(st));
                } else if (mapped.equals(Mapping.SVC.displayName())) {
                    output.setService(getService(st));
                }
            }
        } catch (IOException e) {
            LOG.warn("Exception while reading file: ", e);
        }
        return list;
    }

    private List<JsonNode> convertOutputToJson(List<Output> list) {
        ObjectMapper objectMapper = new ObjectMapper();
        return list.parallelStream()
                .map(op -> objectMapper.convertValue(op, JsonNode.class))
                .collect(Collectors.toList());
    }

    private Subscriber getSubscriber(String st) {
        Subscriber subscriber = new Subscriber();
        subscriber.setCASE_NUMBER(st.substring(3, 18).trim());
        subscriber.setMEM_ID(st.substring(19, 34).trim());
        subscriber.setMEM_FIRST_NAME(st.substring(35, 50).trim());
        subscriber.setMEM_MIDDLE_NAME(st.substring(51, 66).trim());
        subscriber.setMEM_LAST_NAME(st.substring(67, 82).trim());
        subscriber.setMEM_ADD_1(st.substring(83, 98).trim());
        subscriber.setMEM_ADD_2(st.substring(99, 114).trim());
        subscriber.setMEM_CITY(st.substring(115, 130).trim());
        subscriber.setMEM_PIN(st.substring(131, 146).trim());
        return subscriber;
    }

    private Case getCase(String st) {
        Case myCase = new Case();
        myCase.setCASE_NUMBER(st.substring(3, 18).trim());
        myCase.setCASE_TYPE(st.substring(19, 34).trim());
        myCase.setCASE_CODE(st.substring(35, 50).trim());
        myCase.setCASE_START_DATE(st.substring(51, 66).trim());
        myCase.setCASE_END_DATE(st.substring(67, 82).trim());
        myCase.setCASE_AUTH_TYPE(st.substring(83, 98).trim());
        myCase.setCASE_STATUS(st.substring(99, 108).trim());
        return myCase;
    }

    private Patient getPatient(String st) {
        Patient patient = new Patient();
        patient.setCASE_NUMBER(st.substring(3, 18).trim());
        patient.setPAT_ID(st.substring(19, 34).trim());
        patient.setPAT_FIRST_NAME(st.substring(35, 50).trim());
        patient.setPAT_MIDDLE_NAME(st.substring(51, 66).trim());
        patient.setPAT_LAST_NAME(st.substring(67, 82).trim());
        patient.setPAT_SEX(st.substring(83, 98).trim());
        patient.setPAT_DOB(st.substring(99, 114).trim());
        patient.setPAT_PLANE_TYPE(st.substring(115, 130).trim());
        patient.setPAT_PLAN_NAME(st.substring(131, 135).trim());
        return patient;
    }

    private Service getService(String st) {
        Service service = new Service();
        service.setCASE_NUMBER(st.substring(3, 18).trim());
        service.setSVC_ID(st.substring(19, 34).trim());
        service.setSVC_TYPE(st.substring(35, 50).trim());
        service.setSVC_CODE(st.substring(51, 66).trim());
        service.setSVC_FAC_ID(st.substring(67, 82).trim());
        service.setSVC_FAC_NAME(st.substring(83, 98).trim());
        service.setSVC_PHY_ID(st.substring(99, 114).trim());
        service.setSVC_PHY_NAME(st.substring(115, 130).trim());
        return service;
    }
}
