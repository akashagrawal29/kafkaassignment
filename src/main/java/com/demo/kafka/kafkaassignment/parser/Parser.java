package com.demo.kafka.kafkaassignment.parser;

import com.demo.kafka.kafkaassignment.dto.Output;

import java.nio.file.Path;
import java.util.List;

public interface Parser {
    List<Output> parse(Path file);
}
