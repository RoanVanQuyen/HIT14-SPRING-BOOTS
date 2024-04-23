package com.example.baitaptuan6.service.impl;


import com.example.baitaptuan6.Entity.Employee;
import com.example.baitaptuan6.repository.EmployeeRepository;
import com.example.baitaptuan6.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository ;
    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>() ;
        employees = employeeRepository.findAll() ;
        return employees;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        List<Employee> employees = employeeRepository.checkUpdateEmail(employee.getEmployeeEmail(), "") ;
        System.out.println(employees);
        if(employees.size() != 0){
            throw  new RuntimeException("Email đã tồn tại") ;
        }
        employeeRepository.save(employee) ;
        return employee;
    }

    @Override
    public boolean deleteEmployee(List<String > employeeIds) {
        List<Employee> employees = new ArrayList<>() ;
        employees = employeeRepository.findAll() ;
        for(int i = 0 ; i< employees.size() ; i++){
            for(String id: employeeIds){
                if(employees.get(i).getEmployeeId().equals(id)){
                    employeeRepository.delete(employees.get(i));
                }
            }
        }
        return true;
    }

    @Override
    public boolean deleteEmployeeSingle(String employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new RuntimeException("Không tồn tại nhân viên này")
        ) ;
        employeeRepository.delete(employee);
        return true ;
    }

    @Override
    public Employee updEmployee(Employee employee) {
        if(employeeRepository.checkUpdateEmail(employee.getEmployeeEmail(), employee.getEmployeeId()).size() !=  0){
            throw  new RuntimeException("Email đã tồn tại") ;
        }
        employeeRepository.save(employee) ;
        return employee;
    }
}
