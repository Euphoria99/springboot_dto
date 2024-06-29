package com.pavanbhat.newspringdevelopment.repo;

import com.pavanbhat.newspringdevelopment.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
