package com.assignment.book.controller;

import com.assignment.book.model.AuthorEntity;
import com.assignment.book.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    // Create a new author
    @PostMapping("/author")
    public AuthorEntity createAuthor(@Valid @RequestBody AuthorEntity author) {
        return authorRepository.save(author);
    }
}