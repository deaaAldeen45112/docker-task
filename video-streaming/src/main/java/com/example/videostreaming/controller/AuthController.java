package com.example.videostreaming.controller;

import com.example.videostreaming.dto.LoginDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        RestTemplate restTemplate = new RestTemplate();
        String authServiceUrl = "http://auth-service:8001/auth/login";

        try {
             ResponseEntity<String> response = restTemplate.postForEntity(authServiceUrl, loginDTO, String.class);

            if (response.getStatusCode() == HttpStatus.OK && response.getBody().contains("Login successful")) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Authentication service is unavailable");
        }
    }

}

