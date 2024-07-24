package com.example.demo.repository;

import com.example.demo.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    //select * from author where first_name = ${params}
    List<Author> findAllByFirstName(String fn);

    //select * from author where first_name iLIKE ${params}
    List<Author> findAllByFirstNameIgnoreCase(String fn);

    //select * from author where first_name like '%al%'
    List<Author> findAllByFirstNameContainingIgnoreCase(String fn);

    //select * from author where first_name like 'al%'
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String fn);

    //select * from author where first_name like '%al'
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String fn);

    //select * from author where first_name in ('pa', 'van', 'bhat')
    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstNames);

}