package com.example.project.service;

import com.example.project.domain.Author;
import com.example.project.dto.AuthorDto;
import com.example.project.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author saveAuthor(AuthorDto authorDto){
        Author author = new Author(authorDto);
        return authorRepository.save(author);
    }

    public List<Author> showAuthors(){
        return authorRepository.findAll();
    }
}
