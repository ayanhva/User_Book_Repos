package com.example.project.controller;

import com.example.project.domain.User;
import com.example.project.dto.UserDto;
import com.example.project.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ResponseEntity login(
            @RequestHeader("email") String email,
            @RequestHeader("password") String password){
        if(userService.login(email, password)!=null)
            return new ResponseEntity (userService.login(email, password), HttpStatus.OK);
        else return new ResponseEntity("Username or Password is wrong!", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserDto userDto){
        User user = userService.register(userDto);
        return new ResponseEntity("You have successfully registered!", HttpStatus.OK);
    }
}
