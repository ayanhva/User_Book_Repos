package com.example.project.controller;

import com.example.project.service.PersonBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user-book")
public class PersonBookController {

    PersonBookService personBookService;

    public PersonBookController(PersonBookService personBookService) {
        this.personBookService = personBookService;
    }

    @GetMapping("/show/{email}")
    public ResponseEntity showBooksByEmail(
            @PathVariable String email){
        if(personBookService.bookListOfUser(email) != null)
            return new ResponseEntity(personBookService.bookListOfUser(email), HttpStatus.OK);
        else return new ResponseEntity("This user has no books registered!", HttpStatus.NOT_FOUND);
   }

    @PutMapping("/assign/{email}/{title}")
    public ResponseEntity assignBook(
            @PathVariable String email,
            @PathVariable String title
            ){
       personBookService.assignUser(email, title);
        return new ResponseEntity("You have successfully assigned the book to the user!", HttpStatus.OK);
    }

    @DeleteMapping("/remove/{email}/{title}")
    public ResponseEntity removeBook(
            @PathVariable String email,
            @PathVariable String title){
        personBookService.removeBook(email, title);
        return new ResponseEntity("Book unregistered!", HttpStatus.OK);
    }
}