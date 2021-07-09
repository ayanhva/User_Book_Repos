package com.example.project.service;

import com.example.project.domain.Author;
import com.example.project.dto.AuthorDto;
import com.example.project.mapper.AuthorMapper;
import com.example.project.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;
    private AuthorMapper authorMapper;

    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    public Author saveAuthor(AuthorDto authorDto){
        return authorRepository.save(authorMapper.toAuthorEntity(authorDto));
    }

    public List<AuthorDto> showAuthors(){
        return authorMapper.toAuthorDtoList(authorRepository.findAll());
    }
}
