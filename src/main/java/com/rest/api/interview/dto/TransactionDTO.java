package com.rest.api.interview.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rest.api.interview.config.CustomEnumDeserializer;
import com.rest.api.interview.enums.OperationEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    
    @JsonProperty("account_id")
    private Long accountId;

    @JsonProperty("operation_type_id")
    @JsonDeserialize(using = CustomEnumDeserializer.class)
    private OperationEnum operationTypeId;

    @JsonProperty("amount")
    private double amount;
}
