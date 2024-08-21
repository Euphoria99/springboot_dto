package com.example.springsecurity.newspringbootsecurity.service.impl;

import com.example.springsecurity.newspringbootsecurity.security.JwtService;
import com.example.springsecurity.newspringbootsecurity.dto.AuthenticationRequest;
import com.example.springsecurity.newspringbootsecurity.dto.RegisterRequest;
import com.example.springsecurity.newspringbootsecurity.exception.InternalServerException;
import com.example.springsecurity.newspringbootsecurity.exception.InvalidCredentialsException;
import com.example.springsecurity.newspringbootsecurity.exception.ResourceNotFoundException;
import com.example.springsecurity.newspringbootsecurity.exception.UserAlreadyExistsException;
import com.example.springsecurity.newspringbootsecurity.mapper.UserAuthMapper;
import com.example.springsecurity.newspringbootsecurity.model.Role;
import com.example.springsecurity.newspringbootsecurity.model.User;
import com.example.springsecurity.newspringbootsecurity.pojo.AuthenticationResponsePojo;
import com.example.springsecurity.newspringbootsecurity.pojo.SignInPojo;
import com.example.springsecurity.newspringbootsecurity.pojo.SignUpPojo;
import com.example.springsecurity.newspringbootsecurity.repo.UserRepository;
import com.example.springsecurity.newspringbootsecurity.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final UserAuthMapper userAuthMapper;

    @Autowired
    public AuthenticationServiceImpl(UserRepository repository, UserAuthMapper userAuthMapper, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.userAuthMapper = userAuthMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public AuthenticationResponsePojo register(SignUpPojo request) {
        try {
            // Check if the user already exists
            if (repository.findByEmail(request.getEmail()).isPresent()) {
                throw new UserAlreadyExistsException("User with email " + request.getEmail() + " already exists");
            }

            // Proceed with registration
            RegisterRequest registerRequest = userAuthMapper.toRegDto(request);

            var user = User.builder()
                    .firstName(registerRequest.getFirstName())
                    .lastName(registerRequest.getLastName())
                    .email(registerRequest.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.USER)
                    .createdAt(registerRequest.getCreatedAt())
                    .build();

            repository.save(user);

            var jwtToken = jwtService.generateToken(user);
            return AuthenticationResponsePojo.builder()
                    .token(jwtToken)
                    .build();

        } catch (UserAlreadyExistsException ex) {
            throw ex;
        } catch (Exception ex) {
            // Handle other unexpected exceptions
            throw new InternalServerException("An error occurred during registration", ex);
        }
    }


    @Override
    public AuthenticationResponsePojo authenticate(SignInPojo request) {
        try {
            AuthenticationRequest signInRequest = userAuthMapper.toAutDto(request);

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            signInRequest.getEmail(),
                            signInRequest.getPassword()
                    )
            );

            // Fetch user after successful authentication
            var user = repository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new ResourceNotFoundException("User not found"));

            var jwtToken = jwtService.generateToken(user);
            return AuthenticationResponsePojo.builder().token(jwtToken).build();

        } catch (AuthenticationException ex) {
            throw new InvalidCredentialsException("Invalid email or password");
        }
    }

}