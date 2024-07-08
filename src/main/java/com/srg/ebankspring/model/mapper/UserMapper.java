package com.srg.ebankspring.model.mapper;

import com.srg.ebankspring.model.dto.UserDTO;
import com.srg.ebankspring.model.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDTO DTO);
    UserDTO toDTO(User entity);
    List<UserDTO> toDTOList(List<User> users);
    List<User> toEntityList(List<UserDTO> userDTOs);
}

