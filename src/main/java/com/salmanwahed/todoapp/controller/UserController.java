package com.salmanwahed.todoapp.controller;

import com.salmanwahed.todoapp.model.User;
import com.salmanwahed.todoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/signup")
    private User signUp(@RequestBody User user){
        return userService.saveUser(user);
    }

}
