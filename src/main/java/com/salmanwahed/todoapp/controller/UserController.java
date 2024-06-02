package com.salmanwahed.todoapp.controller;

import com.salmanwahed.todoapp.model.User;
import com.salmanwahed.todoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "api/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/signup")
    private ResponseEntity<Object> signUp(@RequestBody User user){
        try {
            user = userService.saveUser(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }catch (Exception exception) {
            Map<String, String> error = new HashMap<>();
            error.put("message", exception.getLocalizedMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }

}
