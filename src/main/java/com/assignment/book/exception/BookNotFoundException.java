package com.assignment.book.exception;

public class BookNotFoundException extends Exception {
    public BookNotFoundException(int bookId) {
        super(String.format("Book is not found with id : '%s'", bookId));
    }
}