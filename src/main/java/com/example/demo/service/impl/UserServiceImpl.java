package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository repo;

    public UserServiceImpl(UserRepository repo){
        this.repo = repo;
    }

    @Override
    public User registerUser(String email , String password){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setCreatedAt(LocalDateTime.now());
        repo.save(user);
        return user;
    }

    @Override
    public Optional<User> getUserByEmail(String email){
        Optional<User> user = repo.findByEmail(email);
        
        return user;
    }
}
