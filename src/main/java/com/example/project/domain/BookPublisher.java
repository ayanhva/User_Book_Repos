package com.example.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreType
public class BookPublisher {

    @Id
    private Long id;

    @ManyToOne
    Publisher publisher;

    @ManyToOne
    @JsonIgnore
    Book book;

    LocalDateTime registeredAt;
}
