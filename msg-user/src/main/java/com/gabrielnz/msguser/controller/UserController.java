package com.gabrielnz.msguser.controller;

import com.gabrielnz.msguser.entities.DTO.UserDTO;
import com.gabrielnz.msguser.entities.User;
import com.gabrielnz.msguser.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> sabeUser(@RequestBody @Valid UserDTO user) {
        User newUser = new User();
        newUser.setEmail(user.email());
        newUser.setName(user.name());
        newUser.setPassword(user.password());
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(newUser));
    }

}
