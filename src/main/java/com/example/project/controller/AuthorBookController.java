package com.example.project.controller;

import com.example.project.service.AuthorBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book-author")
public class AuthorBookController {

    private AuthorBookService authorBookService;

    public AuthorBookController(AuthorBookService authorBookService) {
        this.authorBookService = authorBookService;
    }

    @PutMapping("/assign/{firstName}/{lastName}/{title}")
    public ResponseEntity assign(
            @PathVariable String firstName,
            @PathVariable String lastName,
            @PathVariable String title){
        authorBookService.assignBookAuthor(firstName, lastName, title);
        return new ResponseEntity(authorBookService.assignBookAuthor(firstName, lastName, title), HttpStatus.OK);
    }
}
