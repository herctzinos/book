package com.assignment.book.repository;

import com.assignment.book.model.BookDTO;
import com.assignment.book.model.BookEntity;
import com.assignment.book.model.LibraryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {

    @Query("select new com.assignment.book.model.BookDTO(a.bookId,a.title, a.description, a.isbn," +
            "a.creationDate, a.authorByAuthorId.firstName, a.authorByAuthorId.lastName, a.authorByAuthorId.email," +
            " a.authorByAuthorId.dateOfBirth, a.publisherByPublisherId.name, a.publisherByPublisherId.address ) from BookEntity a where a.bookId = ?1")
    BookDTO retrieveBookAsDTO(int bookId);

    @Query("select new com.assignment.book.model.LibraryDTO(b.bookId,b.title, b.description, b.isbn," +
            " b.authorByAuthorId.firstName, b.authorByAuthorId.lastName ) from BookEntity b where b.publisherByPublisherId is not null" +
            " order by b.authorByAuthorId.lastName , b.isbn desc")
    List<LibraryDTO> retrieveLibraryAsDTO();
}

