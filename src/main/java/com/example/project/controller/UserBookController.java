package com.example.project.controller;

import com.example.project.service.UserBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user-book")
public class UserBookController {

    UserBookService userBookService;

    public UserBookController(UserBookService userBookService) {
        this.userBookService = userBookService;
    }

    @GetMapping("/show/{email}")
    public ResponseEntity showBooksByEmail(
            @PathVariable String email){
        return new ResponseEntity(userBookService.bookListOfUser(email), HttpStatus.OK);
   }

    @PutMapping("/assign/{email}/{title}")
    public ResponseEntity assignBook(
            @PathVariable String email,
            @PathVariable String title
            ){
       userBookService.assignUser(email, title);

        return new ResponseEntity("You have successfully assigned the book to the user!", HttpStatus.OK);
    }
}