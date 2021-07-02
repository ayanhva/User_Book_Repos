package com.example.project.service;

import com.example.project.domain.Book;
import com.example.project.dto.BookDto;
import com.example.project.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    public List<Book> showAllBooks(){
        return bookRepository.findAll();
    }

    public Book showBookByTitle(String title){
        return bookRepository.findBookByTitle(title);
    }

    public Book saveBook(BookDto bookDto){
        Book book = new Book(bookDto);
        bookRepository.save(book);
        return book;
    }
}
