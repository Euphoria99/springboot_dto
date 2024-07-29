package com.example.demo.service;

import com.example.demo.pojo.AuthorPojo;

import java.util.List;

public interface AuthorService {

    List<AuthorPojo> getAllAuthors();

    AuthorPojo saveAuthor(AuthorPojo authorPojo);

    AuthorPojo getAuthorById(Integer id);
}
