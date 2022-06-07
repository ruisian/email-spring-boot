package com.email.service.service;

import com.email.service.datamodel.ERole;
import com.email.service.datamodel.Role;
import com.email.service.datamodel.User;
import com.email.service.repository.UserRepository;
//import com.email.service.util.AppContext;
import com.email.service.util.ApplicationContextProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class DataPopulationService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

//    @Autowired
//    AppContext appContext;

    public DataPopulationService(){
        // createUsers();
    }

//    public User createUsers() {
//        // ApplicationContext applicationContext = AppContext.getInstance().getContext();
//        // UserRepository repo = ApplicationContextProvider.getApplicationContext().getBean(UserRepository.class);
//        // User u1 = new User();
//        //user.setUser(1, "ming", "xiao", LocalDate.of(2000,1,1), "xiaoming@company.com", "xiaoming", "xiaoming123", ERole.Admin);
//        //User user1 = new User(2, "hua", "xiao", LocalDate.of(2000,1,2), "xiaohua@company.com", "xiaohua", "xiaohua123", ERole.User);
////        if (!isUserExist(admin1)){
////            userService.createUser(user);
////        }
//        User user1 = newUser("ming", "xiao", LocalDate.of(2000,1,1), "xiaoming@company.com", "xiaoming", "xiaoming123");
////        if (!isUserExist(user1)){
////            userService.createUser(user1);
////        }
////        User admin1 = newUser();
////        if (!isUserExist(admin1)){
////            userService.createUser(admin1);
////        }
//        return user1;
//    }

    public User newUser(String firstname, String lastname, LocalDate dob, String email, String username, String password) {
        return new User(firstname, lastname, dob, email, username, password);
    }

//    public void addUser(User user) {
//        //UserRepository.save(user);
//    }

    private boolean isUserExist(User u) {
        return false;
    }
}
