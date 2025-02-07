package com.springsecurity.service;

import java.util.List;

import com.springsecurity.exception.UserException;
import com.springsecurity.model.User;

public interface UserService {
    User getUserDetails(String username) throws UserException;
    List<User> getAllUser();
    List<User> getUserByName(String name);
    void removeUserById(Integer userId) throws UserException;

}
