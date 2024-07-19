package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Author extends Auditable{

    private String firstName;

    private String lastName;


    private String email;

    private int age;


    private LocalDateTime createdAt;


    private LocalDateTime lastModified;

    //relation
    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;

}
