package com.example.project.service;

import com.example.project.domain.Author;
import com.example.project.domain.Book;
import com.example.project.dto.BookDto;
import com.example.project.mapper.BookMapper;
import com.example.project.repository.AuthorRepository;
import com.example.project.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorBookService {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    private BookMapper bookMapper;

    public AuthorBookService(AuthorRepository authorRepository, BookRepository bookRepository, BookMapper bookMapper) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public void assignBookAuthor(String firstName, String lastName, String title){
        Author author = authorRepository.findByFirstNameAndLastName(firstName, lastName);
        Book book = bookRepository.findBookByTitle(title);
        book.addAuthors(author);
        bookRepository.save(book);
    }

    public List<BookDto> showBooks(String firstName, String lastName){
        return bookMapper.toBookDtoList(bookRepository.findAllByAuthors(authorRepository.findByFirstNameAndLastName(firstName, lastName)));
    }
}
