package com.example.project.controller;

import com.example.project.domain.Person;
import com.example.project.dto.PersonDto;
import com.example.project.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

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
        Person person = personService.register(personDto);
        return new ResponseEntity("You have successfully registered!", HttpStatus.OK);
    }
}
