package com.example.springsecurity.newspringbootsecurity.service;

import com.example.springsecurity.newspringbootsecurity.pojo.AuthenticationResponsePojo;
import com.example.springsecurity.newspringbootsecurity.pojo.SignInPojo;
import com.example.springsecurity.newspringbootsecurity.pojo.SignUpPojo;

public interface AuthenticationService {

    AuthenticationResponsePojo register(SignUpPojo request);

    AuthenticationResponsePojo authenticate(SignInPojo request);
}
