package com.example.baitaptuan7.service;

import com.example.baitaptuan7.dto.request.EmployeeRequest;
import com.example.baitaptuan7.dto.response.Response;
import org.springframework.data.domain.Pageable;

public interface EmployeeService extends ServiceParent<EmployeeRequest> {
    Response findByName(String name, Pageable pageable) ;
}
