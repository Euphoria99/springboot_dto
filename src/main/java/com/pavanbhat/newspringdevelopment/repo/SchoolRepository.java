package com.pavanbhat.newspringdevelopment.repo;

import com.pavanbhat.newspringdevelopment.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}
