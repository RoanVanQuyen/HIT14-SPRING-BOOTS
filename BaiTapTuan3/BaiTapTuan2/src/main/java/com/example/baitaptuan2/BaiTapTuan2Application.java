package com.example.baitaptuan2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
@Controller
public class BaiTapTuan2Application {

    public static void main(String[] args) {
        SpringApplication.run(BaiTapTuan2Application.class, args);
    }

    @RequestMapping(value = {"","index", "sign-in"}, method = RequestMethod.GET)
    public String signIn(){
        return "index" ;
    }

    @RequestMapping(value = "sign-up" , method = RequestMethod.GET)
    public String signUp(){
        return "signup" ;
    }

}
