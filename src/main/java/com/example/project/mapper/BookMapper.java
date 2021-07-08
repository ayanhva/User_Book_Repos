package com.example.project.mapper;

import com.example.project.domain.Book;
import com.example.project.dto.BookDto;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Data
public class BookMapper {

    private ModelMapper mapper;

    public Book toBookEntity(BookDto bookDto) {
        return mapper.map(bookDto, Book.class);
    }

    public BookDto toBookDto(Book book){
        return mapper.map(book, BookDto.class);
    }
}
