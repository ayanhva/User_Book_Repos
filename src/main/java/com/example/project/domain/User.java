package com.example.project.domain;

import com.example.project.dto.UserDto;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Book> books = new HashSet<>();

    public User(UserDto userDto) {
        firstName = userDto.getFirstName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
        password = userDto.getPassword();
    }
}
