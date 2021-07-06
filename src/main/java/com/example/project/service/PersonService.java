package com.example.project.service;

import com.example.project.domain.Person;
import com.example.project.dto.PersonDto;
import com.example.project.repository.PersonRepository;
import org.springframework.stereotype.Service;


@Service
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person login(String email, String password){
       return personRepository.findPersonByEmailAndPassword(email, password);
    }

    public Person register(PersonDto personDto){
       Person person = new Person(personDto);
       personRepository.save(person);
       return person;
    }
}
