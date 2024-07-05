package com.pavanbhat.newspringdevelopment.service;

import com.pavanbhat.newspringdevelopment.dto.StudentDto;
import com.pavanbhat.newspringdevelopment.dto.StudentResponseDto;
import com.pavanbhat.newspringdevelopment.entity.Student;
import com.pavanbhat.newspringdevelopment.mapper.StudentMapper;
import com.pavanbhat.newspringdevelopment.repo.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    //save student
    public StudentResponseDto saveStudent(StudentDto dto){
        var student = studentMapper.toStudent(dto);
        var savedStudent = repository.save(student);
        return studentMapper.toStudentReposeDto(savedStudent);
    }

    //find all student
    public List<Student> findAllStudent(){
        return  repository.findAll();
    }

    //find by student id
    public Student findById(Integer id){
        return  repository.findById(id)
                .orElse(null);
    }

    //find by student first name
    public List<Student> findByStudentFirstName(String name){
        return  repository.findAllByFirstNameContaining(name);
    }

    //delete a student
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
}
