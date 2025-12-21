package com.example.demo.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class AuthController {

    @Autowired
    public UserService serv;

    @PostMapping("/auth/register")
    public User registerUser(@RequestParam Map<String , String> req ){
        String email = req.get("email");
        String password = req.get("password");
        return serv.registerUser(email, password);
    }

    @PostMapping("/auth/login")
    public Optional<User> loginUser(@RequestParam String email ){
        return serv.getUserByEmail(email);
    }
}
