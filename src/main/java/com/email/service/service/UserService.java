package com.email.service.service;

import com.email.service.datamodel.User;
import com.email.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Optional<User> loadByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user;
    }
}
