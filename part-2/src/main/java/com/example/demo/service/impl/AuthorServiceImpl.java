package com.example.demo.service.impl;

import com.example.demo.dto.AuthorDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.AuthorMapper;
import com.example.demo.models.Author;
import com.example.demo.pojo.AuthorPatchPojo;
import com.example.demo.pojo.AuthorPojo;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    public Page<AuthorPojo> getAllAuthors(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Author> authors = authorRepository.findAll(pageable);
        return authors.map(author -> authorMapper.toPojo(authorMapper.toDto(author)));
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


    @Override
    public AuthorPojo getAuthorById(Integer id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);

        if (optionalAuthor.isPresent()) {
            Author author = optionalAuthor.get();
            AuthorDto authorDto = authorMapper.toDto(author);
            return authorMapper.toPojo(authorDto);
        } else {
            throw new ResourceNotFoundException("Author with id " + id + " not found");
        }
    }
    @Override
    public AuthorPojo putAuthor(AuthorPojo authorPojo) {
        // Convert POJO to DTO
        AuthorDto authorDto = authorMapper.toDto(authorPojo);

        // Fetch the existing author
        Author foundAuthor = authorRepository
                .findById(authorDto.getId()).orElseThrow(
                        () -> new ResourceNotFoundException("Author not found"));

        // Update the fields of the found author with new values
        foundAuthor.setFirstName(authorDto.getFirstName());
        foundAuthor.setLastName(authorDto.getLastName());
        foundAuthor.setEmail(authorDto.getEmail());
        foundAuthor.setAge(authorDto.getAge());
        foundAuthor.setLastModified(LocalDateTime.now());

        // Save the updated author
        Author savedAuthor = authorRepository.save(foundAuthor);

        // Convert saved Author entity back to AuthorPojo
        return authorMapper.toPojo(authorMapper.toDto(savedAuthor));
    }

    @Override
    public AuthorPatchPojo patchAuthor(Integer id, AuthorPatchPojo authorPojo) {
        Optional<Author> foundAuthor = authorRepository.findById(id);

        if (foundAuthor.isPresent()) {
            Author author = foundAuthor.get();

            // Update fields directly on the Author entity
            Author updatedAuthor = Author.builder()
                    .id(author.getId())
                    .firstName(authorPojo.getFirstName() != null ? authorPojo.getFirstName() : author.getFirstName())
                    .lastName(authorPojo.getLastName() != null ? authorPojo.getLastName() : author.getLastName())
                    .email(authorPojo.getEmail() != null ? authorPojo.getEmail() : author.getEmail())
                    .age(authorPojo.getAge() != null ? authorPojo.getAge() : author.getAge())
                    .build();

            // Save the updated Author entity
            updatedAuthor = authorRepository.save(updatedAuthor);

            // Convert the saved Author entity back to AuthorPatchPojo and return it
            return AuthorPatchPojo.builder()
                    .id(updatedAuthor.getId())
                    .firstName(updatedAuthor.getFirstName())
                    .lastName(updatedAuthor.getLastName())
                    .age(updatedAuthor.getAge())
                    .email(updatedAuthor.getEmail())
                    .build();
        } else {
            throw new ResourceNotFoundException("Author with id " + id + " not found or cannot be updated!");
        }
    }

    @Override
    public ResponseEntity<String> deleteAuthorById(Integer id){
        Optional<Author> foundAuthor = authorRepository.findById(id);

        if(foundAuthor.isPresent()){
            authorRepository.deleteById(id);
            return ResponseEntity.ok().body("Author deleted successfully.");
        } else {
            throw new ResourceNotFoundException("Author with id " + id + " not found and cannot be deleted");
        }
    }

    @Override
    public List<AuthorPojo> searchAuthors(String firstName, Integer age, LocalDate from, LocalDate to) {
        List<Author> foundAuthors;

        if (firstName != null && age != null) {
            // If both firstName and age are provided, filter by both
            foundAuthors = authorRepository.findAllByFirstNameStartsWithIgnoreCaseAndAge(firstName, age);
        } else if (firstName != null) {
            // If only firstName is provided, filter by firstName
            foundAuthors = authorRepository.findAllByFirstNameStartsWithIgnoreCase(firstName);
        } else if (age != null) {
            // If only age is provided, filter by age
            foundAuthors = authorRepository.findByNamedQuery(age);
      } else if (from != null & to != null) {
            // If from and to date is provided, filter by date
            foundAuthors = authorRepository.findByCreatedAtBetween(from, to);
        } else {
            // If no parameters are provided, return all authors
            foundAuthors = authorRepository.findAll();
        }

        return foundAuthors.stream()
                .map(author -> authorMapper.toPojo(authorMapper.toDto(author)))
                .collect(Collectors.toList());
    }

}
