package com.pavanbhat.newspringdevelopment.dto;

public record StudentDto(
        String firstName,
        String lastName,
        String email,
        Integer schoolId
) {
}
