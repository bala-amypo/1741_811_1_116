package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class AuthController {

    @Autowired
    public UserService serv;

    @Transactional
    @PostMapping("/auth/register")
    public User registerUser(@RequestParam String email , @RequestParam String password){
        return serv.registerUser(email, password);
    }

    @Transactional
    @PostMapping("/auth/login")
    public Optional<User> loginUser(@RequestParam String email ){
        return serv.getUserByEmail(email);
    }
    
}
