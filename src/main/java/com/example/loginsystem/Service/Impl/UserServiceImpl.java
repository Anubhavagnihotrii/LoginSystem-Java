package com.example.loginsystem.Service.Impl;

import com.example.loginsystem.Entity.User;
import com.example.loginsystem.Repository.UserRepository;
import com.example.loginsystem.Service.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if(user!=null && user.getPassword().equals(password))
        {
            return  true;
        }
        return false;
    }


}
