package com.example.project.controller;

import com.example.project.domain.Author;
import com.example.project.dto.AuthorDto;
import com.example.project.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/save")
    public ResponseEntity saveAuthors(@RequestBody AuthorDto authorDto){
        Author author = authorService.saveAuthor(authorDto);
        return new ResponseEntity("The author was added successfully!", HttpStatus.OK);
    }

    @GetMapping("/showAll")
    public ResponseEntity showAllAuthors(){
        return new ResponseEntity(authorService.showAuthors(), HttpStatus.OK);
    }
}
