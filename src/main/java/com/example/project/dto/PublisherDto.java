package com.example.project.dto;

import com.example.project.domain.BookPublisher;
import lombok.Data;

import java.util.Set;

@Data
public class PublisherDto {

    private String firstName;
    private String lastName;
    Set<BookPublisher> bookPublisherSet;
}
