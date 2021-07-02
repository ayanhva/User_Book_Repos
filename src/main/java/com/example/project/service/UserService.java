package com.example.project.service;

import com.example.project.domain.User;
import com.example.project.dto.UserDto;
import com.example.project.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String email, String password){
       return userRepository.findUserByEmailAndPassword(email, password);
    }

    public User register(UserDto userDto){
       User user = new User(userDto);
       userRepository.save(user);
       return user;
    }
}
