package com.assignment.book.controller;

import com.assignment.book.exception.BookNotFoundException;
import com.assignment.book.model.BookDTO;
import com.assignment.book.model.BookEntity;
import com.assignment.book.model.LibraryDTO;
import com.assignment.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    // Fetch all books
    @GetMapping("/library")
    public List<LibraryDTO> getAllBooks() {
        return bookRepository.retrieveLibraryAsDTO();
    }

    // Create a new book
    @PostMapping("/book")
    public BookEntity createBook(@Valid @RequestBody BookEntity book) {

        return bookRepository.save(book);
    }

    // Fetch a single book
    @GetMapping("/book/{id}")
    public BookDTO getBookById(@PathVariable(value = "id") Integer bookId) throws BookNotFoundException {
        BookDTO bookDTO = bookRepository.retrieveBookAsDTO(bookId);
        if (bookDTO == null) {
            throw new BookNotFoundException(bookId);
        } else return bookDTO;
    }

    // Update a book
    @PutMapping("/book/{id}")
    public BookEntity updateBook(@PathVariable(value = "id") Integer bookId,
                                 @Valid @RequestBody BookEntity bookData) throws BookNotFoundException {

        BookEntity book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));

        book.setTitle(bookData.getTitle());
        book.setDescription(bookData.getDescription());
        book.setAuthorId(bookData.getAuthorId());
        book.setIsbn(bookData.getIsbn());
        book.setCreationDate(bookData.getCreationDate());
        book.setPublisherId(bookData.getPublisherId());
        book.setAuthorId(bookData.getAuthorId());

        return bookRepository.save(book);
    }

    // Delete a book
    @DeleteMapping("/book/{id}")
    public ResponseEntity deleteBook(@PathVariable(value = "id") Integer bookId) throws BookNotFoundException {
        BookEntity book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));

        bookRepository.delete(book);

        return ResponseEntity.ok().build();
    }
}