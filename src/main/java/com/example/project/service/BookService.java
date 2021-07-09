package com.example.project.service;

import com.example.project.domain.Book;
import com.example.project.dto.BookDto;
import com.example.project.mapper.BookMapper;
import com.example.project.repository.BookRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;
    private BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {

        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public List<BookDto> showAllBooks(){
        return bookMapper.toBookDtoList(bookRepository.findAll());
    }

    public  List<BookDto> sortedBooks(String title){
        return bookMapper.toBookDtoList(bookRepository.findAll(Sort.by(Sort.Direction.ASC, "title")));
    }

    public BookDto showBookByTitle(String title){

        return bookMapper.toBookDto(bookRepository.findBookByTitle(title));
    }

    public Book saveBook(BookDto bookDto){
        return bookRepository.save(bookMapper.toBookEntity(bookDto));
    }

    public List<BookDto> showAvailableBooks(){
        
        return bookMapper.toBookDtoList(bookRepository.findAllByPerson(null));
    }

    public BookDto search(String attribute){
        if(bookRepository.findBookByTitle(attribute) != null)
            return bookMapper.toBookDto(bookRepository.findBookByTitle(attribute));
        else if(bookRepository.findBookByIsbn(attribute) != null)
            return bookMapper.toBookDto(bookRepository.findBookByIsbn(attribute));
        else return null;
    }

    public BookDto findByTitle(String title){

        return bookMapper.toBookDto(bookRepository.findBookByTitle(title));
    }

    @Transactional
    public void removeBook(String title){
        bookRepository.deleteBookByTitle(title);
    }
}
