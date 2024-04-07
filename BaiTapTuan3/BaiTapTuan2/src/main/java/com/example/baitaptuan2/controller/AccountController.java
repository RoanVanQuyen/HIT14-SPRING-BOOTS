package com.example.baitaptuan2.controller;

import com.example.baitaptuan2.request.AccountRequest;
import com.example.baitaptuan2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {
    @Autowired
    UserService service ;
    @RequestMapping(value = "/sign-in" , method = RequestMethod.POST)
    public String login(@ModelAttribute AccountRequest request, Model model){
        int code = service.login(request) ;
        if(code == 200){
            model.addAttribute("message" , "Đăng nhập thành công") ;
            return "redirect:/employee/get-all" ;
        }
        else{
            model.addAttribute("message" , "Sai tên đăng nhập hoặc mật khẩu") ;
        }
        return "index";
    }


    @RequestMapping(value = "sign-up", method = RequestMethod.POST)
    public String signUp(@ModelAttribute AccountRequest request , Model model){
        int code = service.signUp(request);
        if(code == 201){
            model.addAttribute("message" , "Tạo tài khoản thành công") ;
        }
        else{
            model.addAttribute("message" , "Tên đăng nhập đã tồn tại");
        }
        return "signup" ;
    }
}
