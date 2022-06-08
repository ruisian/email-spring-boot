package com.email.service.service;

import com.email.service.datamodel.ERole;
import com.email.service.datamodel.Role;
import com.email.service.datamodel.User;
import com.email.service.repository.UserRepository;
//import com.email.service.util.AppContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DataPopulationService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    public DataPopulationService(){
        // createUsers();
    }

    public User newUser(String firstname, String lastname, LocalDate dob, String email, String username, String password, ERole role) {
        return new User(firstname, lastname, dob, email, username, password, role);
    }

    private boolean isUserExist(User u) {
        return false;
    }

    public Role newRole(ERole role) {
        return new Role(role);
    }
}
