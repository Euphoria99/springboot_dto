package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorPatchPojo {
    private int id;

    private String firstName;

    private String lastName;

    private Integer age;

    private String email;
}
