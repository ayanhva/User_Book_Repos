package com.example.project.mapper;

import com.example.project.domain.Person;
import com.example.project.dto.PersonDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person toPersonEntity(PersonDto personDto);

    PersonDto toPersonDto(Person person);

    List<PersonDto> toPersonDtoList(List<Person> personList);
}
