package com.example.baitaptuan2.request;

import org.springframework.stereotype.Component;

@Component
public class SignInRequest {
    private String userName ;
    private String password ;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SignInRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    public SignInRequest(){

    }
}
