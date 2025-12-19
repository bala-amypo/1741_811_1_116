package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.User;

public interface UserService {
    public User registerUser(String email , String password);
    public Optional<User> getUserByEmail(String email);
}
