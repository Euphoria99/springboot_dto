package com.example.demo.service;

import com.example.demo.pojo.AuthorPatchPojo;
import com.example.demo.pojo.AuthorPojo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AuthorService {

    List<AuthorPojo> getAllAuthors();

    AuthorPojo saveAuthor(AuthorPojo authorPojo);

    AuthorPojo getAuthorById(Integer id);

    AuthorPojo putAuthor(AuthorPojo authorPojo);

    AuthorPatchPojo patchAuthor(Integer id, AuthorPatchPojo authorPojo);

    ResponseEntity<String> deleteAuthorById(Integer id);
}
