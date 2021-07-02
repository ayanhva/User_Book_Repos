package com.example.project.service;

import com.example.project.domain.Book;
import com.example.project.domain.User;
import com.example.project.dto.BookDto;
import com.example.project.dto.UserDto;
import com.example.project.repository.BookRepository;
import com.example.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserBookService {

    private UserRepository userRepository;
    private BookRepository bookRepository;

    public UserBookService(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

//    public void assingToUser(@Autowired Set<Book> books, String email){
//        userRepository.findUserByEmail(email).setBooks(books);
//
//    }

    public void assign2(String email, String title){
        User user=userRepository.findUserByEmail(email);
        Book book=bookRepository.findBookByTitle(title);
        user.getBooks().add(book);
        book.setUser(user);
        userRepository.save(user);
        bookRepository.save(book);
    }

}
