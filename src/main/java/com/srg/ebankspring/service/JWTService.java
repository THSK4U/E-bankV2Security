package com.srg.ebankspring.service;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

@Service
public class JWTService {

    private String generateToken(String usernDetails) {
        return Jwts.builder().setSubject(usernDetails).compact();
    };
}
