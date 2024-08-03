package com.example.demo.repository;

import com.example.demo.models.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> , JpaSpecificationExecutor<Author> {

    Page<Author> findAll(Pageable pageable);

    //select * from author where first_name = ${params}
    List<Author> findAllByFirstName(String fn);

    //select * from author where first_name iLIKE ${params}
    List<Author> findAllByFirstNameIgnoreCase(String fn);

    //select * from author where first_name like '%al%'
    List<Author> findAllByFirstNameContainingIgnoreCase(String fn);

    List<Author> findAllByFirstNameStartsWithIgnoreCaseAndAge(String fn, Integer age);

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


    //find by specific age
    List<Author> findByNamedQuery(@Param("age") int age);

    //update  age of all authors by a number
    @Modifying
    @Transactional
    void updateByNamedQuery(@Param("age") int age);

    @Query("SELECT a FROM Author a WHERE DATE(a.createdAt) BETWEEN :from AND :to")
    List<Author> findByCreatedAtBetween(@Param("from") LocalDate from, @Param("to") LocalDate to);
}