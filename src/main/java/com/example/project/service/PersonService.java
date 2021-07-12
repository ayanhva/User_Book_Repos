package com.example.project.service;

import com.example.project.domain.ConfToken;
import com.example.project.domain.Person;
import com.example.project.dto.PersonDto;
import com.example.project.mapper.PersonMapper;
import com.example.project.repository.PersonRepository;
import com.example.project.service.UserService.ConfTokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PersonService {

    private PersonRepository personRepository;
    private PersonMapper personMapper;
    private final ConfTokenService confTokenService;

    public Person login(String email, String password){
        return personRepository.findPersonByEmailAndPassword(email, password);
    }

    public void register(PersonDto personDto){
        Person person = personMapper.toPersonEntity(personDto);
        personRepository.save(person);
//        String token = UUID.randomUUID().toString();
//        ConfToken confToken = new ConfToken(token,
//                LocalDateTime.now(),
//                LocalDateTime.now().plusMinutes(15),
//                person);
//
//        confTokenService.saveConfToken(confToken);
    }
}
