package com.example.project.service;

import com.example.project.domain.Book;
import com.example.project.domain.BookPublisher;
import com.example.project.domain.Publisher;
import com.example.project.dto.PublisherDto;
import com.example.project.mapper.PublisherMapper;
import com.example.project.repository.BookPublisherRepository;
import com.example.project.repository.BookRepository;
import com.example.project.repository.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@AllArgsConstructor
public class PublisherService {

    private PublisherMapper publisherMapper;
    private PublisherRepository publisherRepository;
    private BookRepository bookRepository;
    private BookPublisherRepository bookPublisherRepository;

    public String savePublisher(PublisherDto publisherDto){
        publisherRepository.save(publisherMapper.toPublisherEntity(publisherDto));
        return "Registered";
    }

    public String assignPublisher(String firstName, String title){
        Book book = bookRepository.findBookByTitle(title);
        Publisher publisher = publisherRepository.findByFirstName(firstName);
        BookPublisher bookPublisher = new BookPublisher();
        bookPublisher.setPublisher(publisher);bookPublisher.setBook(book);
        bookPublisher.setRegisteredAt(LocalDateTime.now());
        Random random = new Random();
        bookPublisher.setId(random.nextLong());
        bookPublisherRepository.save(bookPublisher);
        return "Assigned!";
    }
}
