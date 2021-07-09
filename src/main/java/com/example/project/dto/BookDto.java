package com.example.project.dto;

import com.example.project.domain.Author;
import com.example.project.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private String title;
    private String isbn;
    private Person person;
    private List<Author> authors;
}
