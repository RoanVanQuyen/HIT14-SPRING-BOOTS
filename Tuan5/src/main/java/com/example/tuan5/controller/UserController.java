package com.example.tuan5.controller;


import com.example.tuan5.model.User;
import com.example.tuan5.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService ;


    @PostConstruct()
    public ResponseEntity<?> genUser() throws InterruptedException {
//        System.out.println("hello world");
        userService.genUser();
        return ResponseEntity.ok("Generate account success") ;
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody User user){
        userService.add(user) ;
        return ResponseEntity.ok("Add account success") ;
    }



    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(userService.viewAll()) ;
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<?> delUser(@PathVariable String id){
        userService.del(id);
        return ResponseEntity.ok("Delete success") ;
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable String id){
        return  ResponseEntity.ok(userService.findById(id))  ;
    }


}
