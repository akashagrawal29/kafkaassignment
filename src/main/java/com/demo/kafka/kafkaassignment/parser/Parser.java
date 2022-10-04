package com.demo.kafka.kafkaassignment.parser;

import org.apache.avro.specific.SpecificRecordBase;

import java.nio.file.Path;
import java.util.List;

public interface Parser<V extends SpecificRecordBase> {
    List<V> parse(Path file);
}
