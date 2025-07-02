package com.muntasir.authentication.controller;

import com.muntasir.authentication.dto.LoginRequest;
import com.muntasir.authentication.service.auth.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController {
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest loginRequest){
        // NOTE: In a real app, you'd have a user service to validate the password.
        if ("user".equals(loginRequest.getUsername()) && "password".equals(loginRequest.getPassword())) {
            final String token = jwtUtil.generateToken(loginRequest.getUsername());
            return ResponseEntity.ok(Map.of("token", token));
        }
        // If authentication fails
        return ResponseEntity.status(401).body("Error: Invalid credentials");
    }
}