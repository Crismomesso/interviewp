package com.rest.api.interview.config;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.rest.api.interview.enums.OperationEnum;

public class AmountDeserializer extends StdDeserializer<Double> {

    public AmountDeserializer() {
        super(Double.class);
    }

    public AmountDeserializer(Class t) {
        super(t);
    }

    @Override
    public Double deserialize(JsonParser jsonParser, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        Double op = node.asDouble();
        if (op == null) {
            throw new IOException("Invalid Op Bad request");
        }
        return op;
    }

}