package com.example.demo.controller;


import com.example.demo.pojo.AuthorPojo;
import com.example.demo.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    public AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public List<AuthorPojo> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @PostMapping("/authors")
    public  AuthorPojo postAuthors(@Valid @RequestBody AuthorPojo author){
        return authorService.saveAuthor(author);
    }

    @GetMapping("/authors/{id}")
    public AuthorPojo findAuthorById(@PathVariable("id") Integer id){
        return authorService.getAuthorById(id);
    }

    @PutMapping("/authors")
    public  AuthorPojo putAuthors(@Valid @RequestBody AuthorPojo author){
        return authorService.putAuthor(author);
    }
}
