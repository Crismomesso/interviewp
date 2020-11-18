package com.rest.api.interview.mapper;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import com.rest.api.interview.dto.TransactionDTO;
import com.rest.api.interview.enums.OperationEnum;
import com.rest.api.interview.model.Accounts;
import com.rest.api.interview.model.OperationsTypes;
import com.rest.api.interview.model.Transactions;

public final class TransactionsMapper {
    private TransactionsMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Transactions convertToEntity(TransactionDTO dto) {
        final Transactions entity = new Transactions();
        // final Accounts account = new Accounts();
        final OperationsTypes op = new OperationsTypes();

        entity.setEventDate(LocalDate.now());
        entity.setAmount(dto.getAmount());
        // account.setAccountId(dto.getAccountId());
        // entity.setAccountId(account);
        op.setOperationTypeId(dto.getOperationTypeId().getCode());
        entity.setOp(op);
        return entity;
    }

    public static TransactionDTO convertToDTO(Transactions entity) {
        final TransactionDTO dto = new TransactionDTO();
        dto.setAccountId(entity.getAccountId().getAccountId());
        dto.setAmount(entity.getAmount());
        dto.setOperationTypeId(OperationEnum.getByCode(entity.getOp().getOperationTypeId()));
        return dto;
    }

    public static Set<TransactionDTO> makeDTOList(Collection<Transactions> obj) {
        return obj.stream().map(TransactionsMapper::convertToDTO).collect(Collectors.toSet());
    }

    public static Set<Transactions> makeEntityList(Collection<TransactionDTO> obj) {
        return obj.stream().map(TransactionsMapper::convertToEntity).collect(Collectors.toSet());
    }
}
