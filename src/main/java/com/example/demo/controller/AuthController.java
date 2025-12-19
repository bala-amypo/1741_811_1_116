package com.example.demo.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class AuthController {

    @Autowired
    public UserService serv;

    @PostMapping("/register")
    public User registerUser(@RequestBody Map<String , String> req ){
        String email = req.get("email");
        String password = req.get("password");
        return serv.registerUser(email, password);
    }

    @PostMapping("/login")
    public Optional<User> loginUser(@RequestBody String email ){
        return serv.getUserByEmail(email);
    }
}
