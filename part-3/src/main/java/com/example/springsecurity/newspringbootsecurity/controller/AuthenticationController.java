package com.example.springsecurity.newspringbootsecurity.controller;


import com.example.springsecurity.newspringbootsecurity.pojo.AuthenticationResponsePojo;
import com.example.springsecurity.newspringbootsecurity.pojo.SignInPojo;
import com.example.springsecurity.newspringbootsecurity.pojo.SignUpPojo;
import com.example.springsecurity.newspringbootsecurity.service.AuthenticationService;
import jakarta.validation.Valid;
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
    public ResponseEntity<AuthenticationResponsePojo> register(
         @Valid @RequestBody SignUpPojo request
    ){
        return  ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponsePojo> register(
            @Valid   @RequestBody SignInPojo request
    ){
        return  ResponseEntity.ok(authService.authenticate(request));
    }

}
