package com.springsecurity.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurity.exception.UserException;
import com.springsecurity.model.User;
import com.springsecurity.repository.UserRepository;
import com.springsecurity.service.UserService;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public User getUserDetails(String username) throws UserException {
        User checkUser = repository.findByUsername(username).orElse(null);
        if(checkUser==null){
            throw new UserException("Username Not Found");
        }
       return checkUser;
    }

    @Override
    public List<User> getAllUser() {
       return repository.findAll();
    }

    @Override
    public List<User> getUserByName(String name) {
        System.out.println(name);
       return repository.findByName(name);
    }

    @Override
    public void removeUserById(Integer userId) throws UserException {
        User checkUser = repository.findById(userId).orElse(null);
        if (checkUser==null) {
            throw new UserException("Username Not Found");
        }
        repository.deleteById(userId);
        return;
    }
    
}
