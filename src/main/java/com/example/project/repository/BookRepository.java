package com.example.project.repository;

import com.example.project.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

//    @Query("SELECT b from Book b where b.title = ?1")
      Book findBookByTitle(String title);
}
