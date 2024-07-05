package com.pavanbhat.newspringdevelopment.mapper;

import com.pavanbhat.newspringdevelopment.dto.StudentDto;
import com.pavanbhat.newspringdevelopment.dto.StudentResponseDto;
import com.pavanbhat.newspringdevelopment.entity.School;
import com.pavanbhat.newspringdevelopment.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {


    public Student toStudent(StudentDto dto){
        var student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());

        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);

        return student;
    }

    public StudentResponseDto toStudentReposeDto(Student student){
        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }
}
