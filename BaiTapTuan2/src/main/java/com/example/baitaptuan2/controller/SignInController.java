package com.example.baitaptuan2.controller;

import com.example.baitaptuan2.constant.Url;
import com.example.baitaptuan2.request.SignInRequest;
import com.example.baitaptuan2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignInController {
    @Autowired
    UserService service ;
    @RequestMapping(value = "/sign-in" , method = RequestMethod.POST)
    public String login(@ModelAttribute SignInRequest request, Model model){
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
}
