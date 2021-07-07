package com.example.project.repository;

import com.example.project.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByFirstNameAndLastName(String firstname, String lastName);
}
