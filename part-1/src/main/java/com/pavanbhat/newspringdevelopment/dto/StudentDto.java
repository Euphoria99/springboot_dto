package com.pavanbhat.newspringdevelopment.dto;

import jakarta.validation.constraints.NotEmpty;
import org.antlr.v4.runtime.misc.NotNull;

public record StudentDto(

        @NotEmpty(message="First Name should not be empty")
        String firstName,

        @NotEmpty
        String lastName,

        String email,
        Integer schoolId
) {
}
