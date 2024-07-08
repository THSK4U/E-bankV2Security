package com.srg.ebankspring.model.mapper;

import com.srg.ebankspring.model.dto.AccountDTO;
import com.srg.ebankspring.model.entity.Account;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    Account toEntity(AccountDTO DTO);
    AccountDTO toDTO(Account entity);
    List<AccountDTO> toDTOList(List<Account> users);
    List<Account> toEntityList(List<AccountDTO> userDTOs);
}

