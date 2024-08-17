package com.example.springsecurity.newspringbootsecurity.pojo;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpPojo implements Serializable {

    @NotNull(message = "First name is required")
    @NotEmpty(message = "First name cannot be empty")
    private String firstName;

    @NotNull(message = "Last name is required")
    @NotEmpty(message = "Last name cannot be empty")
    private String lastName;

    @NotNull(message = "Email is required")
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email is invalid")
    private String email;

    @NotNull(message = "Password is required")
    @NotEmpty(message = "Password cannot be empty")
    private String password;
}
