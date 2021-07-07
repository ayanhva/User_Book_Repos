package com.example.project.repository;

import com.example.project.domain.Book;
import com.example.project.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

//    @Query("SELECT b from Book b where b.title = ?1")
      Book findBookByTitle(String title);

      Book findBookByIsbn(String isbn);

      List<Book> findAllByPersonId(Long id);

      List<Book> findAllByPerson(Person person);

      Integer deleteBookByTitle(String title);
}
