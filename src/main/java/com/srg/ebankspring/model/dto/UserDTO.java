package com.srg.ebankspring.model.dto;

import com.srg.ebankspring.model.Enum.EnumRole;
import lombok.Data;

@Data
public class UserDTO {
    private Long userId;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private EnumRole role;

}
