package com.salmanwahed.todoapp.service;

import com.salmanwahed.todoapp.model.Todo;
import com.salmanwahed.todoapp.model.User;
import com.salmanwahed.todoapp.model.utils.TodoStatus;
import com.salmanwahed.todoapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    TodoRepository repository;
    @Autowired
    UserService userService;

    public Todo saveTodo(User user, Todo entity) {
        entity.setUser(user);
        if (entity.getStatus() == null){
            entity.setStatus(TodoStatus.IN_PROGRESS);
        }
        return repository.save(entity);
    }

    public List<Todo> getAllTodoByUser(User user){
        return repository.findByUser(user);
    }

    public Todo getById(Long id){
        Optional<Todo> todoOptional = repository.findById(id);
        return todoOptional.orElse(null);
    }

    public List<Todo> getAll() {
        return repository.findAll();
    }
}
