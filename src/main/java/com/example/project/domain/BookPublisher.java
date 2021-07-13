package com.example.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookPublisher {

    @Id
    private Long id;

    @ManyToOne
    Publisher publisher;

    @ManyToOne
    Book book;

    LocalDateTime registeredAt;
}
