package com.assignment.book.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "book", schema = "books_database")
public class BookEntity {
    private int bookId;
    private String title;
    private String description;
    private String isbn;
    private Date creationDate;
    private int publisherId;
    private int authorId;
    private PublisherEntity publisherByPublisherId;
    private AuthorEntity authorByAuthorId;

    @Basic
/*
    @NotNull(message = "test minima must not be empty!")
*/


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "title",nullable = false)
/*
    @NotBlank(message = "Title must not be empty!")
*/
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description", columnDefinition = "default 'empty'")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "ISBN", nullable = false)
/*
    @NotNull(message = "ISBN must not be empty!")
*/
/*
    @Digits(integer = 13, fraction = 0)
*/
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "creation_date")
/*
    @Past
*/
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return bookId == that.bookId &&
                isbn == that.isbn &&
                publisherId == that.publisherId &&
                authorId == that.authorId &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, description, isbn, creationDate, publisherId, authorId);
    }

    @Column(name = "publisher_id")
    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }


    @ManyToOne
/*
    @NotNull(message = "Publisher must not be empty!")
*/
    @JoinColumn(name = "publisher_id", referencedColumnName = "id", insertable=false, updatable=false)
    public PublisherEntity getPublisherByPublisherId() {
        return publisherByPublisherId;
    }

    public void setPublisherByPublisherId(PublisherEntity publisherByPublisherId) {
        this.publisherByPublisherId = publisherByPublisherId;
    }


    @Column(name = "author_id")
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @ManyToOne
/*
    @NotNull(message = "Authoras must not be empty!")
*/
 @JoinColumn(name = "author_id", referencedColumnName = "id", insertable=false, updatable=false)
    public AuthorEntity getAuthorByAuthorId() {
        return authorByAuthorId;
    }

    public void setAuthorByAuthorId(AuthorEntity authorByAuthorId) {
        this.authorByAuthorId = authorByAuthorId;
    }
}