package com.example.project.service;

import com.example.project.domain.Book;
import com.example.project.dto.BookDto;
import com.example.project.repository.BookRepository;
import org.springframework.data.domain.Sort;
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

    public  List<Book> sortedBooks(String title){
        return bookRepository.findAll(Sort.by(Sort.Direction.ASC, "title"));
    }

    public Book showBookByTitle(String title){
        return bookRepository.findBookByTitle(title);
    }

    public Book saveBook(BookDto bookDto){
        Book book = new Book(bookDto);
        bookRepository.save(book);
        return book;
    }

    public List<Book> showAvailableBooks(){
        return bookRepository.findAllByUser(null);
    }
}
