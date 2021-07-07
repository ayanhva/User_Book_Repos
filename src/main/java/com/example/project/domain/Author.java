package com.example.project.domain;


import com.example.project.dto.AuthorDto;
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
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    public Author(AuthorDto authorDto){
        firstName = authorDto.getFirstName();
        lastName = authorDto.getLastName();
    }

    public void addBook(Book book){
        this.books.add(book);
    }
}