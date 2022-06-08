package com.email.service.controller;

import com.email.service.datamodel.ERole;
import com.email.service.datamodel.Email;
import com.email.service.datamodel.Role;
import com.email.service.datamodel.User;
import com.email.service.icd.EmailListData;
import com.email.service.icd.LoginResponse;
import com.email.service.icd.UserCredentials;
//import com.email.service.service.DataPopulationService;
import com.email.service.service.DataPopulationService;
import com.email.service.service.EmailService;
import com.email.service.service.LoginService;
import com.email.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    EmailService emailService;

    User currentUser = null;

    @PostConstruct
    public void init() {
        //dataPopulationService.populateDB();
        Role role;
        role = dataPopulationService.newRole(ERole.Admin);
        if (userService.findRoleByRole(role.getName()) == null) {
            userService.createRole(role);
        }
        role = dataPopulationService.newRole(ERole.User);
        ERole role2 = role.getName();
        if (userService.findRoleByRole(role.getName()) == null) {
            userService.createRole(role);
        }

        User user;
        user = dataPopulationService.newUser("ming", "xiao", LocalDate.of(2000,1,1), "xiaoming@company.com", "xiaoming", "xiaoming123", ERole.Admin);
        if (userService.findByUserName(user.getUsername()) == null) {
            userService.createUser(user);
        }
        user = dataPopulationService.newUser("hua", "xiao", LocalDate.of(2000,1,2), "xiaohua@company.com", "xiaohua", "xiaohua123", ERole.User);
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
        LoginResponse res = loginService.login(credentials);
        if(res.loggedIn) {
            currentUser = userService.findByUserName(credentials.username);
        }
        return res;
    }

    @GetMapping("/users")
    public List<User> findAllUsers() {
        if(currentUser.getRole().equals(ERole.Admin)) {
            return userService.findAllUsers();
        } else {
            System.out.println("not admin, no access");
            return null;
        }
    }

    @PostMapping("/email/send")
    public Email sendEmail(@RequestBody Email email) {
        if (currentUser != null) {
            return emailService.createEmail(email, currentUser);
        } else {
            System.out.println("No user, please log in first");
        }
        return null;
    }

    @GetMapping("/email/inbox")
    public List<EmailListData> emailInbox() {
        if (currentUser != null) {
            return emailService.listEmailSubjects(currentUser.getEmail());
        } else {
            System.out.println("No user, please log in first");
        }
        return null;
    }

    @GetMapping("/email/sent")
    public List<EmailListData> emailsSent() {
        if (currentUser != null) {
            return emailService.listSentEmails(currentUser.getEmail());
        } else {
            System.out.println("No user, please log in first");
        }
        return null;
    }

    @GetMapping("/email/{id}")
    public Email retrieveEmail(@PathVariable int id) {
        if (currentUser != null) {
            return emailService.findById(id);
        } else {
            System.out.println("No user, please log in first");
        }
        return null;
    }
    @PostMapping("/email/{id}")
    public Email archiveEmail(@PathVariable int id, @RequestBody Boolean toArchive) {
        if (currentUser != null) {
            Email email = emailService.findById(id);
            email.setIsArchived(toArchive);
            return emailService.updateDB(email);
        } else {
            System.out.println("No user, please log in first");
        }
        return null;
    }

    @GetMapping("/email/archive")
    public List<EmailListData> retrieveArchivedEmails() {
        if (currentUser != null) {
            return emailService.findArchivedEmails();
        } else {
            System.out.println("No user, please log in first");
        }
        return null;
    }

    @GetMapping("/users/{username}")
    public User findUser(@PathVariable String username) {
        if(currentUser.getRole().equals(ERole.Admin)) {
            return userService.findByUserName(username);
        } else {
            System.out.println("not admin, no access");
            return null;
        }
    }

    @GetMapping("/roles")
    public List<Role> listRoles() {
        if(currentUser.getRole().equals(ERole.Admin)) {
            return userService.findAllRoles();
        } else {
            System.out.println("not admin, no access");
            return null;
        }
    }

    @GetMapping("/roles/{id}")
    public Optional<Role> findRole(@PathVariable int id) {
        return userService.findRoleById(id);
    }
}
