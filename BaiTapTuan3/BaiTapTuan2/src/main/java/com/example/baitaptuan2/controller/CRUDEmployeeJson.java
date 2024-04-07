package com.example.baitaptuan2.controller;

import com.example.baitaptuan2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee")
public class CRUDEmployeeJson {
    @Autowired
    EmployeeService employeeService ;
    @RequestMapping(value = "get-all-json", method = RequestMethod.GET)
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok()
                .body(employeeService.findAll());
    }
}
