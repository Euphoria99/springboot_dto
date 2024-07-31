package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorPatchPojo {
    private int id;

    private String firstName;

    private String lastName;

    private Integer age;

    private String email;
}
