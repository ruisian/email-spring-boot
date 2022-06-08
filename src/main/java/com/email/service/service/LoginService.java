package com.email.service.service;

import com.email.service.datamodel.User;
import com.email.service.icd.LoginResponse;
import com.email.service.icd.UserCredentials;
import com.email.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    public LoginResponse login(UserCredentials credentials) {
        if (credentials.username != null) {
            User user = userRepository.findByUsername(credentials.username);
            if (user != null) {
                return
                        new LoginResponse(
                            credentials.username,
                            user.getPassword().equals(credentials.password)
                        );
            }
        }
        return new LoginResponse(credentials.username, false);
    }
}
