package com.example.demo.service;

import com.example.demo.pojo.AuthorPatchPojo;
import com.example.demo.pojo.AuthorPojo;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;

public interface AuthorService {

    Page<AuthorPojo> getAllAuthors(int page, int size);

    AuthorPojo saveAuthor(AuthorPojo authorPojo);

    AuthorPojo getAuthorById(Integer id);

    AuthorPojo putAuthor(AuthorPojo authorPojo);

    AuthorPatchPojo patchAuthor(Integer id, AuthorPatchPojo authorPojo);

    ResponseEntity<String> deleteAuthorById(Integer id);

    List<AuthorPojo> searchAuthors(String firstName, Integer age, LocalDate from, LocalDate to);
}
