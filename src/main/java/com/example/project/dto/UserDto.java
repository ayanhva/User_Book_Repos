package com.example.project.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
