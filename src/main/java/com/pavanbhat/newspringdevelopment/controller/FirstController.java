package com.pavanbhat.newspringdevelopment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

    @GetMapping("/hello")
    public String sayHello(){
        return "hello from my first controller!";
    }

    @PostMapping("/post")
    public String post(@RequestBody String name){
        return "Request Accepted " + name;
    }
}
