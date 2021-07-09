package com.example.project.mapper;

import com.example.project.domain.Book;
import com.example.project.dto.BookDto;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toBookEntity(BookDto bookDto);

    BookDto toBookDto(Book book);

    List<BookDto> toBookDtoList(List<Book> books);
}
