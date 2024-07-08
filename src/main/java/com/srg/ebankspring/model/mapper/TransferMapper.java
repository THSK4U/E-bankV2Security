package com.srg.ebankspring.model.mapper;

import com.srg.ebankspring.model.dto.TransferDTO;
import com.srg.ebankspring.model.entity.Transfer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransferMapper {
    Transfer toEntity(TransferDTO DTO);
    TransferDTO toDTO(Transfer entity);
    List<TransferDTO> toDTOList(List<Transfer> users);
    List<Transfer> toEntityList(List<TransferDTO> userDTOs);
}
