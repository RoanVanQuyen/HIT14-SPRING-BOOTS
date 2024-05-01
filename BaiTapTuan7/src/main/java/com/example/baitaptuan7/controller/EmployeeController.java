package com.example.baitaptuan7.controller;

import com.example.baitaptuan7.dto.request.EmployeeRequest;
import com.example.baitaptuan7.dto.response.Response;
import com.example.baitaptuan7.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService ;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeRequest request){
        Response response = employeeService.add(request) ;
        return ResponseEntity.status(response.getCode())
                .body(response)  ;
    }

    @RequestMapping(value = "/{employeeId}" , method = RequestMethod.PUT)
    public ResponseEntity<?> updEmployee(@PathVariable String employeeId ,
                                         @RequestBody EmployeeRequest request){
        Response response = employeeService.upd(employeeId , request) ;
        return ResponseEntity.status(response.getCode())
                .body(response)  ;
    }

    @RequestMapping(value = "/{employeeIds}"  , method = RequestMethod.DELETE)
    public ResponseEntity<?> delEmployee(@PathVariable List<String> employeeIds){
        Response response = employeeService.delete(employeeIds) ;
        return ResponseEntity.status(response.getCode())
                .body(response)  ;
    }

    @RequestMapping(value = "/name/{employeeName}", method = RequestMethod.GET)
    public ResponseEntity<?> findByName(@PathVariable String employeeName,
                                        @RequestParam(defaultValue = "1" , required = false) int pageIndex,
                                        @RequestParam(defaultValue = "9" , required = false) int pageSize){
        Pageable pageable = PageRequest.of(pageIndex -1 , pageIndex) ;
        Response response = employeeService.findByName(employeeName, pageable) ;
        return ResponseEntity.status(response.getCode())
                .body(response)  ;
    }
    @RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable String employeeId){
        Response response = employeeService.findById(employeeId) ;
        return ResponseEntity.status(response.getCode())
                .body(response)  ;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findByName(@RequestParam(defaultValue = "1" , required = false) int pageIndex,
                                        @RequestParam(defaultValue = "9" , required = false) int pageSize){
        Pageable pageable = PageRequest.of(pageIndex -1 , pageIndex) ;
        Response response = employeeService.getAll(pageable) ;
        return ResponseEntity.status(response.getCode())
                .body(response)  ;
    }
}
