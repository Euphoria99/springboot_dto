package com.pavanbhat.newspringdevelopment.controller;

import com.pavanbhat.newspringdevelopment.dto.StudentDto;
import com.pavanbhat.newspringdevelopment.dto.StudentResponseDto;
import com.pavanbhat.newspringdevelopment.entity.Student;
import com.pavanbhat.newspringdevelopment.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/students")
    public StudentResponseDto saveStudent(@RequestBody StudentDto dto){
        return this.studentService.saveStudent(dto);
    }



    @GetMapping("/students")
    public List<StudentResponseDto> findAllStudent(){
        return  studentService.findAllStudent();
    }

    @GetMapping("/students/{student-id}")
    public StudentResponseDto findById(@PathVariable("student-id") Integer id){
        return  studentService.findById(id);
    }

    @GetMapping("/students/search/{student-name}")
    public List<StudentResponseDto> findByStudentFirstName(@PathVariable("student-name") String name){
        return  studentService.findByStudentFirstName(name);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("student-id") Integer id){
         studentService.deleteById(id);
    }
}
