package com.example.project.repository;

import com.example.project.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findPersonByEmailAndPassword(String email, String password);

//    @Query("SELECT u from User u where u.email = ?1")
    Person findPersonByEmail(String email);

    UserDetails findByEmail(String email);
}
