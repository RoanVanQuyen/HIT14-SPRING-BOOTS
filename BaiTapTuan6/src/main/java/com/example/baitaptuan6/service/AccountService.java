package com.example.baitaptuan6.service;

import com.example.baitaptuan6.request.AccountRequest;
import com.example.baitaptuan6.response.Response;

public interface AccountService {
    public Response signUp(AccountRequest request) ;
    Response signIn(String username , String password) ;
}
