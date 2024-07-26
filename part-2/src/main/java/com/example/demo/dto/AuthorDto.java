package com.example.demo.dto;

import com.example.demo.models.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {

    private String firstName;

    private String lastName;

    private String email;

    private int age;

    private LocalDateTime createdAt;

    private LocalDateTime lastModified;

    private List<Course> courses;
}
