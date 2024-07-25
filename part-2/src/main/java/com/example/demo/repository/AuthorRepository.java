package com.example.demo.repository;

import com.example.demo.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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

    //update Author a set a.age = 22 where a.id = 1
    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id = :id")
    int updateAgeAuthor(int age,int id);

    //update Author a set a.age = 22 where a.id = 1
    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age")
    int updateAgeofAllAuthor(int age);


    List<Author> findByNamedQuery(@Param("age") int age);
}