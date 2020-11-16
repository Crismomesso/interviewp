package com.rest.api.interview.config;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.rest.api.interview.enums.OperationEnum;

public class CustomEnumDeserializer extends StdDeserializer<OperationEnum> {

    public CustomEnumDeserializer() {
        super(OperationEnum.class);
    }

    public CustomEnumDeserializer(Class t) {
        super(t);
    }

    @Override
    public OperationEnum deserialize(JsonParser jsonParser, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        OperationEnum op = OperationEnum.getByCode(node.asLong());
        if (op == null) {
            throw new IOException("Invalid Op Bad request");
        }
        return op;
    }

}