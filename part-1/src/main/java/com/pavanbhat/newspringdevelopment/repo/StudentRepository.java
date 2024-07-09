package com.pavanbhat.newspringdevelopment.repo;

import com.pavanbhat.newspringdevelopment.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    List<Student> findAllByFirstNameContaining(String firstname);
}
