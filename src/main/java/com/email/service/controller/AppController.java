package com.email.service.controller;

import com.email.service.datamodel.Role;
import com.email.service.datamodel.User;
import com.email.service.icd.LoginResponse;
import com.email.service.icd.UserCredentials;
//import com.email.service.service.DataPopulationService;
import com.email.service.service.DataPopulationService;
import com.email.service.service.LoginService;
import com.email.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class AppController {

    @Autowired
    LoginService loginService;

    @Autowired
    UserService userService;

    @Autowired
    DataPopulationService dataPopulationService;

    @PostConstruct
    public void init() {
        //User user = dataPopulationService.createUsers();
        User user = dataPopulationService.newUser("ming", "xiao", LocalDate.of(2000,1,1), "xiaoming@company.com", "xiaoming", "xiaoming123");
        if (userService.findByUserName(user.getUsername()) == null) {
            userService.createUser(user);
        }
        user = dataPopulationService.newUser("hua", "xiao", LocalDate.of(2000,1,2), "xiaohua@company.com", "xiaohua", "xiaohua123");
        if (userService.findByUserName(user.getUsername()) == null) {
            userService.createUser(user);
        }

    }


     @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody UserCredentials credentials) {
        return loginService.login(credentials);
    }

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/users/{username}")
    public User findUser(@PathVariable String username) {
        return userService.findByUserName(username);
    }

    @GetMapping("/role/{id}")
    public Optional<Role> findRole(@PathVariable int id) {
        return userService.findRoleById(id);
    }
}
