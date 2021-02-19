package com.assignment.book.controller;

import com.assignment.book.model.PublisherEntity;
import com.assignment.book.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class PublisherController {

    @Autowired
    PublisherRepository publisherRepository;

    // Create a new publisher
    @PostMapping("/publisher")
    public PublisherEntity createPublisher(@Valid @RequestBody PublisherEntity publisher) { return publisherRepository.save(publisher); }
}