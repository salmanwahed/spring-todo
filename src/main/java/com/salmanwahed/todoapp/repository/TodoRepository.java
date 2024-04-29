package com.salmanwahed.todoapp.repository;

import com.salmanwahed.todoapp.model.Todo;
import com.salmanwahed.todoapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUser(User user);
}
