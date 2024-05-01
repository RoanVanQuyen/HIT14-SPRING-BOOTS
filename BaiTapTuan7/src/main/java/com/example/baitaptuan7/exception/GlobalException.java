package com.example.baitaptuan7.exception;

import com.example.baitaptuan7.dto.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<?> runtimeException(RuntimeException e){
        Response response = Response.builder()
                .code(400)
                .message(e.getMessage())
                .build() ;
        return ResponseEntity.status(response.getCode())
                .body(response) ;
    }
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> methodNotAllowed(HttpRequestMethodNotSupportedException e){
        Response response = Response.builder()
                .code(400)
                .message("Phương thức " + e.getMethod() + " không được phép truy cập")
                .build() ;
        return ResponseEntity.status(response.getCode())
                .body(response) ;
    }
}
