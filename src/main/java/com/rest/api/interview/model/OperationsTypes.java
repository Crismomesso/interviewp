package com.rest.api.interview.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "operations_types")
public class OperationsTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long operationTypeId;

    @NotNull
    @NotBlank
    private String description;
}
