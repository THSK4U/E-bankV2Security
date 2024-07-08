package com.srg.ebankspring.service;

import com.srg.ebankspring.model.dto.UserDTO;
import com.srg.ebankspring.model.entity.User;
import com.srg.ebankspring.model.mapper.UserMapper;
import com.srg.ebankspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDto) {
        User user = userMapper.toEntity(userDto);
        UserDTO userdto = userMapper.toDTO(userRepository.save(user));
        return userdto;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.delete(userRepository.findById(userId).get());
    }

    @Override
    public List<UserDTO> GetAllUser() {
        List<User> users = userRepository.findAll();
        return userMapper.toDTOList(users);
    }

}
