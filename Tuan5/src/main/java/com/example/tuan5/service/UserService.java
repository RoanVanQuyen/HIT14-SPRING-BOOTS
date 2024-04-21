package com.example.tuan5.service;

import com.example.tuan5.model.User;

import java.util.List;

public interface UserService {
    void genUser() throws InterruptedException;
    User add(User u) ;
    void del(String uId) ;
    List<User> viewAll() ;
    User findById(String id ) ;

}
