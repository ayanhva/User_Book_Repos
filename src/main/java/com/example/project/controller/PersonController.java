package com.example.project.controller;

import com.example.project.dto.PersonDto;
import com.example.project.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;
    private final BookController bookController;

    @GetMapping("/login")
    public ResponseEntity login(
            @RequestHeader("email") String email,
            @RequestHeader("password") String password){
        if(personService.login(email, password)!=null)
            return new ResponseEntity (personService.login(email, password), HttpStatus.OK);
        else return new ResponseEntity("Username or Password is wrong!", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody PersonDto personDto){
        return new ResponseEntity(personService.register(personDto), HttpStatus.OK);
    }
}
