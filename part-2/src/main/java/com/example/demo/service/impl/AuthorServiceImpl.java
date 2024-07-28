package com.example.demo.service.impl;

import com.example.demo.dto.AuthorDto;
import com.example.demo.exception.ErrorResponse;
import com.example.demo.mapper.AuthorMapper;
import com.example.demo.models.Author;
import com.example.demo.pojo.AuthorPojo;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public List<AuthorPojo> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream()
                .map(author -> authorMapper.toPojo(authorMapper.toDto(author)))
                .collect(Collectors.toList());
    }

    @Override
    public AuthorPojo saveAuthor(AuthorPojo authorPojo) {

        //pojo to dto
        AuthorDto authorDto = authorMapper.toDto(authorPojo);

        //dto to entity
        Author author = authorMapper.toEntity(authorDto);

        //save author
        Author savedAuthor = authorRepository.save(author);

        // Convert saved Author entity back to AuthorPojo
        return authorMapper.toPojo(authorMapper.toDto(savedAuthor));
    }

    public class AuthorNotFoundException extends RuntimeException {
        public AuthorNotFoundException(String message) {
            super(message);
        }
    }

    @Override
    public ResponseEntity<?> getAuthorById(Integer id) {
        try {
            Optional<Author> optionalAuthor = authorRepository.findById(id);

            if (optionalAuthor.isPresent()) {
                Author author = optionalAuthor.get();
                AuthorDto authorDto = authorMapper.toDto(author);
                AuthorPojo authorPojo = authorMapper.toPojo(authorDto);
                return ResponseEntity.ok(authorPojo);
            } else {
                throw new AuthorNotFoundException("Author with id " + id + " not found");
            }
        } catch (AuthorNotFoundException ex) {
            ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }
}
