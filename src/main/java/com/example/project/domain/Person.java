package com.example.project.domain;

import com.example.project.dto.PersonDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @OneToMany(mappedBy = "person", cascade = {CascadeType.ALL})
    @JsonIgnore
    private Set<Book> books = new HashSet<>();

    public void addBook(Book book){
        this.books.add(book);
    }

    public Person(PersonDto personDto) {
        firstName = personDto.getFirstName();
        lastName = personDto.getLastName();
        email = personDto.getEmail();
        password = personDto.getPassword();
    }
}
