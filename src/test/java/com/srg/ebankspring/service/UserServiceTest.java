package com.srg.ebankspring.service;

import com.srg.ebankspring.model.Enum.EnumRole;
import com.srg.ebankspring.model.dto.UserDTO;
import com.srg.ebankspring.model.entity.User;
import com.srg.ebankspring.model.mapper.UserMapper;
import com.srg.ebankspring.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private UserMapper userMapper;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createUser() {
        UserDTO userDto = new UserDTO();
        userDto.setUsername("taha");
        userDto.setEmail("taha@gmail.com");
        userDto.setPassword("taha");
        userDto.setPhoneNumber("43");
        userDto.setRole(EnumRole.ADMIN);

        userMapper.toEntity(any(UserDTO.class));
        userRepository.save(any(User.class));
        userMapper.toDTO(any(User.class));

        userService.createUser(userDto);

    }
}
