package com.example.project.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
public class ConfToken {

    @SequenceGenerator(
            name = "confirmation_sequence",
            sequenceName = "confirmation_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "confirmation_sequence")
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
