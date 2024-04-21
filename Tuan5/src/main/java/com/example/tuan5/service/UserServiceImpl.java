package com.example.tuan5.service;

import com.example.tuan5.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Service
public class UserServiceImpl implements UserService{
    List<User> users = new ArrayList<>()  ;

    @Override
    public void genUser() throws InterruptedException {
        users.add(User.builder()
                        .username("RQuyen")
                        .password("123456")
                .build()) ;
        users.add(User.builder()
                        .username("HIT_CLUB")
                        .password("1808")
                .build()) ;

        Runnable runnable =() -> IntStream.range(0,10)
                .forEach( i-> {
                    users.add(User.builder()
                                    .username(UUID.randomUUID().toString())
                                    .password("123456")
                                    .build()
                    ) ;
                });
        Thread one = new Thread(runnable) ;
        Thread two = new Thread(runnable) ;
        one.start();
        two.start();
        one.join();
    }

    @Override
    public User add(User u) {
        for(User user : users){
            if(user.getUsername().equals(u.getUsername())){
                throw new RuntimeException("Username is existed") ;
            }
        }
        users.add(u) ;
        return u;
    }

    @Override
    public void del(String uId) {
        for(int i = 0 ; i < users.size() ; i++){
            if(users.get(i).getAccountId().equals(uId)){
                users.remove(users.get(i)) ;
                return ;
            }
        }
        throw new RuntimeException("Account not existed") ;
    }

    @Override
    public List<User> viewAll() {
        return users;
    }

    @Override
    public User findById(String id) {
        for(User user : users){
            if(user.getAccountId().equals(id)){
                return user ;
            }
        }
        throw new RuntimeException("Account not existed") ;
    }
}
