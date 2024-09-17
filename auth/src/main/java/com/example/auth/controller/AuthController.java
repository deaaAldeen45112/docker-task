package com.example.auth.controller;


import com.example.auth.dto.LoginDTO;
import com.example.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody LoginDTO credentials) {
        boolean isAuthenticated = authService.authenticate(credentials.getUsername(), credentials.getPassword());
        return isAuthenticated ? "Login successful" : "Invalid credentials";
    }
}