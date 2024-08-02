package com.example.demo.mapper;

import com.example.demo.dto.AuthorDto;
import com.example.demo.models.Author;
import com.example.demo.pojo.AuthorPatchPojo;
import com.example.demo.pojo.AuthorPojo;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;

@Component
public class AuthorMapper {

    // Converts AuthorDto to AuthorPojo
    public AuthorPojo toPojo(AuthorDto authorDto){
        return new AuthorPojo(
                authorDto.getId(),
                authorDto.getFirstName(),
                authorDto.getLastName(),
                authorDto.getAge(),
                authorDto.getEmail(),
                authorDto.getCreatedAt()
        );
    }

    // Converts AuthorPojo to AuthorDto
    public AuthorDto toDto(AuthorPojo authorPojo) {
        return new AuthorDto(
                authorPojo.getId(),
                authorPojo.getFirstName(),
                authorPojo.getLastName(),
                authorPojo.getEmail(),
                authorPojo.getAge(),
                LocalDateTime.now(), // Set the current time as createdAt
                LocalDateTime.now(), // Set the current time as lastModified
                Collections.emptyList() // Initialize with an empty list for courses
        );
    }

    // Converts Author entity to AuthorDto - Retrieval
    public AuthorDto toDto(Author author){
        return new AuthorDto(
                author.getId(),
                author.getFirstName(),
                author.getLastName(),
                author.getEmail(),
                author.getAge(),
                author.getCreatedAt(),
                author.getLastModified(),
                author.getCourses()
        );
    }


    // Converts AuthorDto to Author entity, - Persisting
    public Author toEntity(AuthorDto authorDto){
        Author author = new Author();
        author.setId(author.getId());
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());
        author.setEmail(authorDto.getEmail());
        author.setAge(authorDto.getAge());
        author.setCreatedAt(authorDto.getCreatedAt());
        author.setLastModified(authorDto.getLastModified());
        author.setCourses(authorDto.getCourses());
        return author;
    };

    // Converts AuthorDto to AuthorPatchPojo
    public AuthorPatchPojo toPatchPojo(AuthorDto authorDto){
        return new AuthorPatchPojo(
                authorDto.getId(),
                authorDto.getFirstName(),
                authorDto.getLastName(),
                authorDto.getAge(),
                authorDto.getEmail(),
                authorDto.getCreatedAt()
        );
    }
}
