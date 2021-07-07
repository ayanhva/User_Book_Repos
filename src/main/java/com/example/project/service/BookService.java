package com.example.project.service;

import com.example.project.domain.Book;
import com.example.project.dto.BookDto;
import com.example.project.repository.BookRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        return bookRepository.findAllByPerson(null);
    }

    public Book search(String attribute){
        if(bookRepository.findBookByTitle(attribute) != null) return bookRepository.findBookByTitle(attribute);
        else if(bookRepository.findBookByIsbn(attribute) != null) return bookRepository.findBookByIsbn(attribute);
        else return null;
    }

    public Book findByTitle(String title){
        return bookRepository.findBookByTitle(title);
    }

    @Transactional
    public void removeBook(String title){
        bookRepository.deleteBookByTitle(title);
    }
}
