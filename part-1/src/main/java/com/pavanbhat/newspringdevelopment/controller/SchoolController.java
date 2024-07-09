package com.pavanbhat.newspringdevelopment.controller;

import com.pavanbhat.newspringdevelopment.dto.SchoolDto;
import com.pavanbhat.newspringdevelopment.repo.SchoolRepository;
import com.pavanbhat.newspringdevelopment.service.SchoolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/schools")
    public SchoolDto postSchool(@RequestBody SchoolDto dto){
        return schoolService.postStudent(dto);
    }

    @GetMapping("/schools")
    public List<SchoolDto> findAll(){
            return schoolService.findAll();
    }
}
