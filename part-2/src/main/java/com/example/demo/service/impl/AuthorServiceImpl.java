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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
}
