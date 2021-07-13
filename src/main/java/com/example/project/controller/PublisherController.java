package com.example.project.controller;

import com.example.project.dto.PublisherDto;
import com.example.project.service.PublisherService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Configuration
@RequestMapping("/publishers")
@AllArgsConstructor
public class PublisherController {

    private PublisherService publisherService;

    @PostMapping("/register")
    public ResponseEntity addPublisher(@RequestBody PublisherDto publisherDto){
        return new ResponseEntity(publisherService.savePublisher(publisherDto), HttpStatus.OK);
    }

    @PutMapping("/assign/{firstName}/{title}")
    public ResponseEntity assignBook(
            @PathVariable String firstName,
            @PathVariable String title){
        return new ResponseEntity(publisherService.assignPublisher(firstName, title), HttpStatus.OK);
    }
}
