package com.example.project.service;

import com.example.project.domain.ConfToken;
import com.example.project.domain.Person;
import com.example.project.dto.PersonDto;
import com.example.project.mapper.PersonMapper;
import com.example.project.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PersonService implements UserDetailsService {

    private PersonRepository personRepository;
    private PersonMapper personMapper;
    private final ConfTokenService confTokenService;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return personRepository.findByEmail(email);
    }

    public String login(String email, String password){
        Person person = personRepository.findPersonByEmailAndPassword(email, password);
        if(personRepository.findPersonByEmailAndPassword(email, password) == null) return "Icorrect email or password!";
        return "Successful login!";
    }

    public String register(PersonDto personDto){
        Person person = personMapper.toPersonEntity(personDto);
        if(personRepository.findPersonByEmail(person.getEmail()) != null) return "Email is taken!";
        person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));
        personRepository.save(person);

        String token = UUID.randomUUID().toString();
        ConfToken confToken = new ConfToken(token, LocalDateTime.now(), LocalDateTime.now().plusMinutes(15), person);
        confTokenService.saveConfToken(confToken);
        return "You ave successfully registered!";
    }
}
