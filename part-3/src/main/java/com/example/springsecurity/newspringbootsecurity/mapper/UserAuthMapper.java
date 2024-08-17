package com.example.springsecurity.newspringbootsecurity.mapper;

import com.example.springsecurity.newspringbootsecurity.dto.AuthenticationRequest;
import com.example.springsecurity.newspringbootsecurity.dto.RegisterRequest;
import com.example.springsecurity.newspringbootsecurity.pojo.SignInPojo;
import com.example.springsecurity.newspringbootsecurity.pojo.SignUpPojo;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserAuthMapper {

    // Converts SignUpPojo to RegisterRequest
    public RegisterRequest toRegDto(SignUpPojo SignupPojo) {
        return new RegisterRequest(
                SignupPojo.getFirstName(),
                SignupPojo.getLastName(),
                SignupPojo.getEmail(),
                SignupPojo.getPassword(),
                LocalDateTime.now() // Set the current time as createdAt
        );
    }

    // Converts SignInPojo to AuthenticationRequest
    public AuthenticationRequest toAutDto(SignInPojo SigninPojo) {
        return new AuthenticationRequest(
                SigninPojo.getEmail(),
                SigninPojo.getPassword()
        );
    }

}
