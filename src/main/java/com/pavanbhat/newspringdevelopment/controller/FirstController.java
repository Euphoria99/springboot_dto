package com.pavanbhat.newspringdevelopment.controller;

import com.pavanbhat.newspringdevelopment.entity.Student;
import com.pavanbhat.newspringdevelopment.repo.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FirstController {

    private final StudentRepository repository;

    public FirstController(StudentRepository repository){
        this.repository = repository;
    }

    @PostMapping("/students")
    public Student post(@RequestBody Student student){
        return  repository.save(student);
    }

    @GetMapping("/students")
    public List<Student> findAllStudent(){
        return  repository.findAll();
    }

    @GetMapping("/students/{student-id}")
    public Student findById(@PathVariable("student-id") Integer id){
        return  repository.findById(id)
                             .orElse(null);
    }
}
