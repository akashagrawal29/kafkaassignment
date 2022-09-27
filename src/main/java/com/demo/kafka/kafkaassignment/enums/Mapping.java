package com.demo.kafka.kafkaassignment.enums;

public enum Mapping {
    SUB("SUB"),
    PAT("PAT"),
    CAS("CAS"),
    SVC("SVC");

    private String displayName;

    Mapping(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() {
        return displayName;
    }
}
