package com.example.baitaptuan2.service;

import com.example.baitaptuan2.request.AccountRequest;

public interface UserService {
    public int login(AccountRequest request) ;
    public int signUp(AccountRequest request) ;
}
