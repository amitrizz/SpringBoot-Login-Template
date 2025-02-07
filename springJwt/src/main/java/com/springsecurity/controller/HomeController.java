package com.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.exception.UserException;
import com.springsecurity.model.User;
import com.springsecurity.security.jwt.JwtUtils;
import com.springsecurity.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class HomeController {
    
    private final UserService userService;
    private final JwtUtils jwtUtils;

    @GetMapping
    public ResponseEntity<User> profile(@RequestHeader("Authorization") String authToken) throws UserException {
        String token = authToken.substring(7);
        String username = jwtUtils.extractUsername(token);
        return ResponseEntity.ok(userService.getUserDetails(username));
    }
}
