package com.springsecurity.dto;

import com.springsecurity.model.User;

import lombok.Data;

@Data
public class JwtResponse {
    private String token;
    private User user;
    
}
