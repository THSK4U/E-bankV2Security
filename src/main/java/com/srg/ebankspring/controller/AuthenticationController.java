package com.srg.ebankspring.controller;

import com.srg.ebankspring.model.AuthenticationResponse;
import com.srg.ebankspring.model.dto.UserDTO;
import com.srg.ebankspring.model.entity.User;
import com.srg.ebankspring.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

@PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody UserDTO user){
    return ResponseEntity.ok(authenticationService.register(user));
}
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody UserDTO user){
        return ResponseEntity.ok(authenticationService.authenticate(user));
    }
}
