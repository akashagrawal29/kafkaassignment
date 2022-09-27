package com.demo.kafka.kafkaassignment.parser;

import com.fasterxml.jackson.databind.JsonNode;

import java.nio.file.Path;
import java.util.List;

public interface Parser {
    List<JsonNode> parse(Path file);
}
