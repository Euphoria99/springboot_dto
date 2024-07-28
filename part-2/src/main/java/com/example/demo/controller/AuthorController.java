package com.example.demo.controller;


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
    public ResponseEntity<?> findAuthorById(@PathVariable Integer id) {
        return authorService.getAuthorById(id);
    }
}
