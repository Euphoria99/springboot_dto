package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
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
@NamedQueries(
        {
    @NamedQuery(
        name="Author.findByNamedQuery",
        query="select a from Author a where a.age >= :age"
    ),
    @NamedQuery(
        name="Author.updateByNamedQuery",
        query="update Author a set a.age =:age"
    )
        }
)
public class Author extends Auditable{

    private String firstName;

    private String lastName;


    private String email;

    private Integer age;


    private LocalDateTime createdAt;


    private LocalDateTime lastModified;

    //relation
    @ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
    private List<Course> courses;

}
