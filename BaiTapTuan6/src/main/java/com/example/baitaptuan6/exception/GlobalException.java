package com.example.baitaptuan6.exception;

import com.example.baitaptuan6.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = Exception.class)
    public String exception(Exception e , Model model){
        model.addAttribute("message" , "Lỗi gì đó chưa test ra , HIHI") ;
        return "exception" ;
    }
    @ExceptionHandler(value = RuntimeException.class)
    public String runtimeException(RuntimeException e , Model model){
        model.addAttribute("message" , e.getMessage()) ;
        return "exception" ;
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public String requestNotSupport(HttpRequestMethodNotSupportedException e , Model model){
        model.addAttribute("message" , "Phương thức " + e.getMethod() + " không được hỗ trợ " ) ;
        return "exception" ;
    }

    @ExceptionHandler(value = NoResourceFoundException.class)
    public String pageNotFound(NoResourceFoundException e , Model model){
        model.addAttribute("message" , "Địa chỉ trang web không được hỗ trợ") ;
        return "exception" ;
    }
}
