package com.email.service.service;

import com.email.service.datamodel.ERole;
import com.email.service.datamodel.Role;
import com.email.service.datamodel.User;
import com.email.service.repository.RoleRepository;
import com.email.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public User loadByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }

    public List<User> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<Role> findRoleById(int id) {
        return roleRepository.findById(id);
    }

    public Role findRoleByRole(ERole role) {
        return roleRepository.findByName(role);
    }

    public void createUser(User user) {
        User u = userRepository.save(user);
    }

    public void createRole(Role role) {
        Role r = roleRepository.save(role);
    }
}
