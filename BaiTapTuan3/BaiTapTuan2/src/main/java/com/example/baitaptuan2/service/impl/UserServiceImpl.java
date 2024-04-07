package com.example.baitaptuan2.service.impl;

import com.example.baitaptuan2.request.AccountRequest;
import com.example.baitaptuan2.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private Map<String, String> saveAccount = new HashMap<>() ;
    {
        saveAccount.put("admin" , "1234") ;
        saveAccount.put("RQuyen" , "1234") ;
        saveAccount.put("DTAnh" , "1234") ;
    }
    @Override
    public int login(AccountRequest request) {
        String password = saveAccount.get(request.getUserName());
        if(password==null){
            return 400 ;
        }
        if(password.equals(request.getPassword())){
            return 200 ;
        }
        return 400;
    }

    @Override
    public int signUp(AccountRequest request) {
        if(saveAccount.get(request.getUserName()) == null){
            saveAccount.put(request.getUserName(),  request.getPassword()) ;
            return 201;
        }
        return 400 ;
    }
}
