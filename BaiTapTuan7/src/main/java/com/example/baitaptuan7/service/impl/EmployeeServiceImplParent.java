package com.example.baitaptuan7.service.impl;

import com.example.baitaptuan7.dto.request.EmployeeRequest;
import com.example.baitaptuan7.dto.response.Response;
import com.example.baitaptuan7.entity.Employee;
import com.example.baitaptuan7.mapper.EmployeeMapper;
import com.example.baitaptuan7.repository.EmployeeRepository;
import com.example.baitaptuan7.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplParent implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository ;
    @Autowired
    EmployeeMapper employeeMapper ;


    @Override
    public Response add(EmployeeRequest employeeRequest) {
        Employee employee = employeeMapper.toEmployee(employeeRequest) ;
        employee  = employeeRepository.save(employee) ;
        return Response.builder()
                .result(employee)
                .message("Thêm thành công 'Employee' ")
                .code(201)
                .build();
    }


    @Override
    public Response delete(List<String> requestId) {
        List<Employee> employees = new ArrayList<>() ;
        for(String x : requestId){
            Optional<Employee> employeeOptional = employeeRepository.findById(x) ;
            if(employeeOptional.isPresent()){
                employees.add(employeeOptional.get()) ;
                employeeRepository.delete(employeeOptional.get());
            }
        }
        return Response.builder()
                .code(200)
                .result(employees)
                .message("Xoá thành công danh sách ' Company' ")
                .build();
    }

    @Override
    public Response upd(String id , EmployeeRequest employeeRequest) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Không tồn tại nhân viên này")
        ) ;
        employeeMapper.updEmployee(employee , employeeRequest);
        employee = employeeRepository.save(employee) ;
        return Response.builder()
                .result(employee)
                .message("Cập nhập thành công 'Employee' ")
                .code(200)
                .build();
    }

    @Override
    public Response findById(String id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Không tồn tại nhân viên này")
        ) ;
        return Response.builder()
                .result(employee)
                .message("Tìm kiếm thành công 'Employee' ")
                .code(200)
                .build();
    }

    @Override
    public Response getAll(Pageable pageable) {
        return Response.builder()
                .code(200)
                .message("Tìm kiếm thành công 'Employee' ")
                .result(employeeRepository.findAll(pageable))
                .build();
    }

    @Override
    public Response findByName(String name, Pageable pageable) {
        return Response.builder()
                .code(200)
                .message("Tìm kiếm thành công 'Employee' ")
                .result(employeeRepository.findEmployeeByEmployeeNameContainingIgnoreCase(name ,pageable))
                .build();
    }
}
