package com.srg.ebankspring.model.mapper;

import com.srg.ebankspring.model.dto.TransactionDTO;
import com.srg.ebankspring.model.dto.UserDTO;
import com.srg.ebankspring.model.entity.Transaction;
import com.srg.ebankspring.model.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    Transaction toEntity(TransactionDTO DTO);
    TransactionDTO toDTO(Transaction entity);
    List<TransactionDTO> toDTOList(List<Transaction> transactions);
    List<Transaction> toEntityList(List<TransactionDTO> userDTOs);
}

