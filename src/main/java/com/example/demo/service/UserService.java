package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
    public User registerUser(String email , String password);
    public User getUserByEmail(String email);
}
