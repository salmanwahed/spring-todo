package com.salmanwahed.todoapp.service;

import com.salmanwahed.todoapp.model.User;
import com.salmanwahed.todoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository repository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public User saveUser(User entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return repository.save(entity);
    }

    public User getUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    public User getById(Long id){
        Optional<User> userOptional = repository.findById(id);
        return userOptional.orElse(null);
    }


}
