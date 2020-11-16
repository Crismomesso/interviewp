package com.rest.api.interview.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.rest.api.interview.dto.AccountDTO;
import com.rest.api.interview.model.Accounts;

public final class AccountsMapper {

    private AccountsMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Accounts convertToEntity(AccountDTO dto) {
        final Accounts entity = new Accounts();
        entity.setAccountId(dto.getAccountId());
        entity.setDocumentNumber(dto.getDocumentNumber());
        return entity;
    }

    public static AccountDTO convertToDTO(Accounts entitty) {
        final AccountDTO dto = new AccountDTO();
        dto.setAccountId(entitty.getAccountId());
        dto.setDocumentNumber(entitty.getDocumentNumber());
        return dto;
    }

    public static List<AccountDTO> makeUsersDTOList(Collection<Accounts> client) {
        return client.stream().map(AccountsMapper::convertToDTO).collect(Collectors.toList());
    }

}