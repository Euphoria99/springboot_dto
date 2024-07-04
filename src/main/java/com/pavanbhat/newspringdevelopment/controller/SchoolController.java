package com.pavanbhat.newspringdevelopment.controller;

import com.pavanbhat.newspringdevelopment.dto.SchoolDto;
import com.pavanbhat.newspringdevelopment.entity.School;
import com.pavanbhat.newspringdevelopment.repo.SchoolRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {

    private  SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository){
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/schools")
    public SchoolDto create(@RequestBody SchoolDto dto){
        var school = toSchool(dto);
       schoolRepository.save(school);
       return dto;
    }

    private School toSchool(SchoolDto dto) {
        return new School(dto.name());
    }

    private SchoolDto toSchoolDto(School school){
        return new SchoolDto(school.getName());
    }

    @GetMapping("/schools")
    public List<SchoolDto> findAll(){
       return schoolRepository
               .findAll()
               .stream()
               .map(this:: toSchoolDto)
               .collect(Collectors.toList());
    }
}
