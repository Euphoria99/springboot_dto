package com.pavanbhat.newspringdevelopment.dto;

import org.antlr.v4.runtime.misc.NotNull;

public record StudentDto(
        String firstName,
        String lastName,
        String email,
        Integer schoolId
) {
}
