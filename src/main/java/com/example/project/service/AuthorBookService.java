package com.example.project.service;

import com.example.project.domain.Author;
import com.example.project.domain.Book;
import com.example.project.repository.AuthorRepository;
import com.example.project.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.persistence.Column;

@Service
public class AuthorBookService {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public AuthorBookService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public void assignBookAuthor(String firstName, String lastName, String title){
        Author author = authorRepository.findByFirstNameAndLastName(firstName, lastName);
        Book book = bookRepository.findBookByTitle(title);
        book.addAuthor(author);
        bookRepository.save(book);
    }
}
