package com.springsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.exception.UserException;
import com.springsecurity.model.User;
import com.springsecurity.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/admin")
public class AdminController {

     @Autowired
    private UserService userService;

    @GetMapping("all-user")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @GetMapping("/search")
    public ResponseEntity<List<User>> userByName(@RequestParam String name) {
        return ResponseEntity.ok(userService.getUserByName(name));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> removeUser(@RequestParam Integer userid) throws UserException {
        userService.removeUserById(userid);
        
        return ResponseEntity.ok("User Deleted Successfully");
    }
    
    
    
}
