package com.pavanbhat.newspringdevelopment.mapper;

import com.pavanbhat.newspringdevelopment.dto.StudentDto;
import com.pavanbhat.newspringdevelopment.dto.StudentResponseDto;
import com.pavanbhat.newspringdevelopment.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void  shouldMapStudentDtoToStudent() {
        StudentDto dto = new StudentDto("john","doe", "john@gmail.com", 1);

        Student student = mapper.toStudent(dto);

        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());
    }

    @Test
    public void shouldMapStudentToStudentResponseDto(){

        Student student = new Student("pav","bhat", "john@gmail.com", 1);

        StudentResponseDto dto = mapper.toStudentReposeDto(student);

        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());
    }

    @Test
    public void should_throw_null_pointer_exception_when_studentDto_is_null(){
        var exp = assertThrows(NullPointerException.class, () -> mapper.toStudent(null));
        assertEquals("The StudentDto cannot be null", exp.getMessage());
    }
}