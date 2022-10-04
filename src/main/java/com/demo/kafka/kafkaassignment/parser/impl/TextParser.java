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
public class TextParser implements Parser<OutputAvroModel> {

    private static final Logger LOG = LoggerFactory.getLogger(TextParser.class);

    @Override
    public List<OutputAvroModel> parse(Path file) {
        LOG.info("Parsing file: {}", file.getFileName());
        List<OutputAvroModel> list = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String st;
            OutputAvroModel.Builder output = OutputAvroModel.newBuilder();
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
                        list.add(output.build());
                        output = OutputAvroModel.newBuilder();
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

    private List<JsonNode> convertOutputToJson(List<OutputAvroModel> list) {
        ObjectMapper objectMapper = new ObjectMapper();
        return list.parallelStream()
                .map(op -> objectMapper.convertValue(op, JsonNode.class))
                .collect(Collectors.toList());
    }

    private Subscriber getSubscriber(String st) {
        Subscriber subscriber = new Subscriber();
        subscriber.setCaseNUMBER(st.substring(3, 18).trim());
        subscriber.setMemID(st.substring(19, 34).trim());
        subscriber.setMemFIRSTNAME(st.substring(35, 50).trim());
        subscriber.setMemMIDDLENAME(st.substring(51, 66).trim());
        subscriber.setMemLASTNAME(st.substring(67, 82).trim());
        subscriber.setMemADD1(st.substring(83, 98).trim());
        subscriber.setMemADD2(st.substring(99, 114).trim());
        subscriber.setMemCITY(st.substring(115, 130).trim());
        subscriber.setMemPIN(st.substring(131, 146).trim());
        subscriber.setMysource("");
        return subscriber;
    }

    private Mycase getCase(String st) {
        Mycase myCase = new Mycase();
        myCase.setCaseNUMBER(st.substring(3, 18).trim());
        myCase.setCaseTYPE(st.substring(19, 34).trim());
        myCase.setCaseCODE(st.substring(35, 50).trim());
        myCase.setCaseSTARTDATE(st.substring(51, 66).trim());
        myCase.setCaseENDDATE(st.substring(67, 82).trim());
        myCase.setCaseAUTHTYPE(st.substring(83, 98).trim());
        myCase.setCaseSTATUS(st.substring(99, 108).trim());
        myCase.setMysource("");
        return myCase;
    }

    private Patient getPatient(String st) {
        Patient patient = new Patient();
        patient.setCaseNUMBER(st.substring(3, 18).trim());
        patient.setPatID(st.substring(19, 34).trim());
        patient.setPatFIRSTNAME(st.substring(35, 50).trim());
        patient.setPatMIDDLENAME(st.substring(51, 66).trim());
        patient.setPatLASTNAME(st.substring(67, 82).trim());
        patient.setPatSEX(st.substring(83, 98).trim());
        patient.setPatDOB(st.substring(99, 114).trim());
        patient.setPatPLANETYPE(st.substring(115, 130).trim());
        patient.setPatPLANNAME(st.substring(131, 135).trim());
        patient.setMysource("");
        return patient;
    }

    private Service getService(String st) {
        Service service = new Service();
        service.setCaseNUMBER(st.substring(3, 18).trim());
        service.setSvcID(st.substring(19, 34).trim());
        service.setSvcTYPE(st.substring(35, 50).trim());
        service.setSvcCODE(st.substring(51, 66).trim());
        service.setSvcFACID(st.substring(67, 82).trim());
        service.setSvcFACNAME(st.substring(83, 98).trim());
        service.setSvcPHYID(st.substring(99, 114).trim());
        service.setSvcPHYNAME(st.substring(115, 130).trim());
        service.setMysource("");
        return service;
    }
}
