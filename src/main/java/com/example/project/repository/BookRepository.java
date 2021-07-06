package com.example.project.repository;

import com.example.project.domain.Book;
import com.example.project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

//    @Query("SELECT b from Book b where b.title = ?1")
      Book findBookByTitle(String title);

      List<Book> findAllByUserId(Long id);

      List<Book> findAllByUser(User user);
}
