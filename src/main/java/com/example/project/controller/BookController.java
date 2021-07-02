package com.example.project.controller;

import com.example.project.domain.Book;
import com.example.project.domain.User;
import com.example.project.dto.BookDto;
import com.example.project.dto.UserDto;
import com.example.project.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/showAll")
    public ResponseEntity getAll(){
            if(bookService.showAllBooks()!=null) return new ResponseEntity (bookService.showAllBooks(), HttpStatus.OK);
            else return new ResponseEntity("No registered books!", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/show")
    public ResponseEntity getByTitle(
            @RequestHeader("title") String title){
        if(bookService.showBookByTitle(title)!=null)
            return new ResponseEntity (bookService.showBookByTitle(title), HttpStatus.OK);
        else return new ResponseEntity("A book with such title does not exist!", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity register(@RequestBody BookDto bookDto){
        Book book = bookService.saveBook(bookDto);
        return new ResponseEntity("You have successfully registered the book!", HttpStatus.NOT_FOUND);
    }
}
