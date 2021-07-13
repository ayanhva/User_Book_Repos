package com.example.project.mapper;

import com.example.project.domain.Publisher;
import com.example.project.dto.PublisherDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PublisherMapper {

    Publisher toPublisherEntity(PublisherDto publisherDto);

    PublisherDto toPublisherDto(Publisher publisher);
}
