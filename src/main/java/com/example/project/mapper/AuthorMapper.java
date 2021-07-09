package com.example.project.mapper;

import com.example.project.domain.Author;
import com.example.project.dto.AuthorDto;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface AuthorMapper {

    Author toAuthorEntity(AuthorDto authorDto);

    AuthorDto toAuthorDto(Author author);

    List<AuthorDto> toAuthorDtoList(List<Author> authors);

}
