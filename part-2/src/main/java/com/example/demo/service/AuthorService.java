package com.example.demo.service;

import com.example.demo.pojo.AuthorPojo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AuthorService {

    List<AuthorPojo> getAllAuthors();

    AuthorPojo saveAuthor(AuthorPojo authorPojo);

    ResponseEntity<?> getAuthorById(Integer id);
}
