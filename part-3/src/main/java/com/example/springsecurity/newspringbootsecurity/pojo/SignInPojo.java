package com.example.springsecurity.newspringbootsecurity.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignInPojo implements Serializable {

    private String email;

    private String password;
}
