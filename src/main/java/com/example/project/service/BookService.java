package com.example.project.service;

import com.example.project.domain.Book;
import com.example.project.dto.BookDto;
import com.example.project.repository.BookRepository;
import com.example.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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
