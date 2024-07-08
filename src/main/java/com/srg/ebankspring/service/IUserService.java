package com.srg.ebankspring.service;

import com.srg.ebankspring.model.dto.UserDTO;

import java.util.List;

public interface IUserService {
    public UserDTO createUser(UserDTO user);
    public void deleteUser(Long userId);
    public List<UserDTO> GetAllUser();
}
