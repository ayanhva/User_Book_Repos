package com.example.project.service;

import com.example.project.domain.Person;
import com.example.project.dto.PersonDto;
import com.example.project.mapper.PersonMapper;
import com.example.project.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;
    private PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public Person login(String email, String password){
       return personRepository.findPersonByEmailAndPassword(email, password);
    }

    public void register(PersonDto personDto){
       personRepository.save(personMapper.toPersonEntity(personDto));
    }
}
