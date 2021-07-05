package com.example.project.domain;

import com.example.project.dto.BookDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @ManyToOne()
    @JoinColumn(name = "user_email")
//    @JoinTable(name = "book_user", joinColumns = @JoinColumn(name = "book_title"), inverseJoinColumns = @JoinColumn(name = "user_email"))
    private User user;

    private String title;
    private String author;
    private String isbn;

    public Book(BookDto bookDto) {
        title = bookDto.getTitle();
        author = bookDto.getAuthor();
        isbn = bookDto.getIsbn();
    }

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
}
