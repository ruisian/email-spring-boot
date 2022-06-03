package com.email.service.service;

import com.email.service.datamodel.User;
import com.email.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User loadByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }

    public List<User> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }
}
