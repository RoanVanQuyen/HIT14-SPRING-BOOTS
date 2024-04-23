package com.example.baitaptuan6.controller;


import com.example.baitaptuan6.request.AccountRequest;
import com.example.baitaptuan6.response.Response;
import com.example.baitaptuan6.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

    @Autowired
    AccountService service ;

    @RequestMapping(value = {"" , "/index" , "/main" , "sign-in"} , method = RequestMethod.GET)
    public String home(){
        return "index" ;
    }
    @RequestMapping(value = {"/sign-up"} , method = RequestMethod.GET)
    public String signUp(){
        return "signup" ;
    }

    @RequestMapping(value = "/sign-up" , method = RequestMethod.POST)
    public String singUp(@ModelAttribute AccountRequest request, Model model){
        System.out.println(request.toString());
        Response response = service.signUp(request) ;
        if(response.getCode() == 200){
            model.addAttribute("message" , "Đăng kí thành công") ;
            return "index" ;
        }
        else{
            model.addAttribute("message" , response.getMessage()) ;
            return "signup" ;
        }
    }


    @RequestMapping(value = "/sign-in" ,  method = RequestMethod.POST)
    public String signIn(@RequestParam String username
                        , @RequestParam String password , Model model){
        Response response = service.signIn(username, password) ;
        if(response.getCode() == 200){
            model.addAttribute("message" , "Đăng nhập thành công") ;
            return "redirect:/employee/get-all" ;
        }
        else{
            model.addAttribute("message" , response.getMessage()) ;
        }
        return "index";
    }

}
