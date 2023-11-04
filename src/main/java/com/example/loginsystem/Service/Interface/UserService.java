package com.example.loginsystem.Service.Interface;

import com.example.loginsystem.Entity.User;

import java.util.List;

public interface UserService {
    User add(User user);

    boolean existsByEmail(String email);
    boolean authenticateUser(String email, String password);
}
