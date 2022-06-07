package com.email.service.icd;

public class LoginResponse {
    public String username;
    public Boolean loggedIn;

    public LoginResponse(String username, boolean b) {
        this.username = username;
        this.loggedIn = b;
    }
}
