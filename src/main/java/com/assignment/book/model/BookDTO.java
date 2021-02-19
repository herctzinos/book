package com.assignment.book.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


public class BookDTO {


    private int bookId;
    private String title;
    private String description;
    private String isbn;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "EET")
    private java.util.Date creationDate;
    private String authorFirstName;
    private String authorLastName;
    private String authorEmail;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMMM yyyy", timezone = "EET")
    private java.util.Date authorDOB;
    private String publisherName;
    private String publisherAddress;


    public BookDTO(int bookId, String title, String description, String isbn, java.util.Date creationDate, String authorFirstName,
                   String authorLastName, String authorEmail, java.util.Date authorDOB, String publisherName, String publisherAddress) {
        this.bookId = bookId;
        this.title = title;
        this.description = description;
        this.isbn = isbn;
        this.creationDate = creationDate;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.authorEmail = authorEmail;
        this.authorDOB = authorDOB;
        this.publisherName = publisherName;
        this.publisherAddress = publisherAddress;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public java.util.Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public java.util.Date getAuthorDOB() {
        return authorDOB;
    }

    public void setAuthorDOB(Date authorDOB) {
        this.authorDOB = authorDOB;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherAddress() {
        return publisherAddress;
    }

    public void setPublisherAddress(String publisherAddress) {
        this.publisherAddress = publisherAddress;
    }

}