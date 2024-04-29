package com.salmanwahed.todoapp.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.salmanwahed.todoapp.config.AppUserDetails;
import com.salmanwahed.todoapp.model.Todo;
import com.salmanwahed.todoapp.model.User;
import com.salmanwahed.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "api/todo")
public class TodoController {
    @Autowired
    TodoService todoService;
    @PostMapping(value = "/create")
    public Todo createTodo(Authentication authentication, @RequestBody Todo entity) {
        AppUserDetails appUserDetails = (AppUserDetails) authentication.getPrincipal();
        return todoService.saveTodo(appUserDetails.getUser(), entity);
    }
    @GetMapping(value = "/my/todos")
    public List<Todo> myTodos(User user) {
        return todoService.getAllTodoByUser(user);
    }
    @GetMapping(value = "/read/all")
    public List<Todo> allTodos() {
        return todoService.getAll();
    }
}
