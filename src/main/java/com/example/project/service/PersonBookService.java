package com.example.project.service;

import com.example.project.domain.Book;
import com.example.project.domain.Person;
import com.example.project.dto.BookDto;
import com.example.project.mapper.BookMapper;
import com.example.project.repository.BookRepository;
import com.example.project.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonBookService {

    private PersonRepository personRepository;
    private BookRepository bookRepository;

    private BookMapper bookMapper;

    public PersonBookService(PersonRepository personRepository, BookRepository bookRepository, BookMapper bookMapper) {
        this.personRepository = personRepository;
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public void assignUser(String email, String title) {
        Book book = bookRepository.findBookByTitle(title);
        book.setPerson(personRepository.findPersonByEmail(email));
        bookRepository.save(book);
    }

    public List<BookDto> bookListOfUser(String email) {
        Person person = personRepository.findPersonByEmail(email);
        return bookMapper.toBookDtoList(bookRepository.findAllByPersonId(person.getId()));
    }

    public void removeBook(String email, String title){
        Book book = bookRepository.findBookByTitle(title);
        book.setPerson(null);
        bookRepository.save(book);
    }
}