package com.example.demo.service.impl;

import com.example.demo.dto.AuthorDto;
import com.example.demo.mapper.AuthorMapper;
import com.example.demo.models.Author;
import com.example.demo.pojo.AuthorPojo;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper){
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public List<AuthorPojo> getAllAuthors(){
        List<Author> authors = authorRepository.findAll();
        return authors.stream()
                .map(author -> authorMapper.toPojo(authorMapper.toDto(author)))
                .collect(Collectors.toList());
    }

    public AuthorPojo saveAuthor(AuthorPojo authorPojo){

        //pojo to dto
        AuthorDto authorDto =  authorMapper.toDto(authorPojo);

        //dto to entity
        Author author = authorMapper.toEntity(authorDto);

        //save author
        Author savedAuthor = authorRepository.save(author);

        // Convert saved Author entity back to AuthorPojo
        return authorMapper.toPojo(authorMapper.toDto(savedAuthor));
    }

}
