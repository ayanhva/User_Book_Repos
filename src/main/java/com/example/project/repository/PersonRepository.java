package com.example.project.repository;

import com.example.project.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findPersonByEmailAndPassword(String email, String password);

    Person findPersonByEmail(String email);

    UserDetails findByEmail(String email);
}
