package com.example.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
public class ConfToken {

    @Id
    private Long id;
    private String token;
    private LocalDateTime localDateTime;
    private LocalDateTime expiredAt;
    @ManyToOne
    @JoinColumn(name = "person_id")
    public Person person;

    public ConfToken(String token, LocalDateTime localDateTime, LocalDateTime expiredAt, Person person) {
        this.token = token;
        this.localDateTime = localDateTime;
        this.expiredAt = expiredAt;
        this.person = person;
    }
}
