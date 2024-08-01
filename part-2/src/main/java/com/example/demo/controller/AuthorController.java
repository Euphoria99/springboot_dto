package com.example.demo.controller;


import com.example.demo.pojo.AuthorPatchPojo;
import com.example.demo.pojo.AuthorPojo;
import com.example.demo.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PatchMapping("/authors/{id}")
    public AuthorPatchPojo patchAuthors(@PathVariable("id") Integer id, @RequestBody AuthorPatchPojo authorPojo){
        return authorService.patchAuthor(id, authorPojo);
    }

    @DeleteMapping("/authors/{id}")
    public ResponseEntity<String> deleteAuthorById(@PathVariable("id") Integer id){
        return authorService.deleteAuthorById(id);
    }

    @GetMapping("/authors/search")
    public List<AuthorPojo> searchAuthors(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) Integer age){
        return authorService.searchAuthors(firstName, age);
    }
}
