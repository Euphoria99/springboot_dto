package com.example.springsecurity.newspringbootsecurity.controller;

import com.example.springsecurity.newspringbootsecurity.dto.AuthenticationRequest;
import com.example.springsecurity.newspringbootsecurity.dto.AuthenticationResponse;
import com.example.springsecurity.newspringbootsecurity.dto.RegisterRequest;
import com.example.springsecurity.newspringbootsecurity.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        return  ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest request
    ){
        return  ResponseEntity.ok(authService.authenticate(request));
    }

}
