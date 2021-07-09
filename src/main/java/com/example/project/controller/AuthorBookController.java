package com.example.project.controller;

import com.example.project.service.AuthorBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
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
        return new ResponseEntity("Assignment complete!", HttpStatus.OK);
    }

    @GetMapping("/show/{firstName}/{lastName}")
    public ResponseEntity showBooks(
            @PathVariable String firstName,
            @PathVariable String lastName){
        return new ResponseEntity(authorBookService.showBooks(firstName, lastName), HttpStatus.OK);
    }
}
