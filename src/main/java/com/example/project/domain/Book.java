package com.example.project.domain;

import com.example.project.dto.BookDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne()
    @JoinColumn(name = "person_id")
//    @JoinTable(name = "book_person", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "person_id"))
    private Person person;

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
