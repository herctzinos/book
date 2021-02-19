package com.assignment.book.model;

import org.apache.commons.lang3.StringUtils;

public class LibraryDTO {

    private int bookId;
    private String title;
    private String description;
    private String isbn;
    private String authorFirstName;
    private String authorLastName;

    public LibraryDTO(int bookId, String title, String description, String isbn, String authorFirstName, String authorLastName) {
        this.bookId = bookId;
        this.title = title;
        this.description = StringUtils.substring(description, 0, 100) + "...";
        this.isbn = isbn;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;

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
}
