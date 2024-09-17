package com.example.auth.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public boolean authenticate(String username, String password) {

        return "user".equals(username) && "password".equals(password);
    }
}