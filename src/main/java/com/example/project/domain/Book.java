package com.example.project.domain;

import com.example.project.dto.BookDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String title;
    private String isbn;

    @ManyToOne()
    @JoinColumn(name = "person_id")
//    @JoinTable(name = "book_person", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "person_id"))
    private Person person;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    public void addAuthor(Author author){
        this.authors.add(author);
    }

    public Book(BookDto bookDto) {
        title = bookDto.getTitle();
        isbn = bookDto.getIsbn();
    }

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }
}
