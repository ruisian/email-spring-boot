package com.email.service.controller;

import com.email.service.datamodel.Role;
import com.email.service.datamodel.User;
import com.email.service.repository.RoleRepository;
import com.email.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AppController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/login")
    public String login() {
        return "Greetings from Login";
    }

    @GetMapping("/users/{username}")
    public Optional<User> findUser(@PathVariable String username) {
        return userRepository.findByUsername(username);
    }

    @GetMapping("/role/{id}")
    public Optional<Role> findRole(@PathVariable int id) {
        return roleRepository.findById(id);
    }
}
