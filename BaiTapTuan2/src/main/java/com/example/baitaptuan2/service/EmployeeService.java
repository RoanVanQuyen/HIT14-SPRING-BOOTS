package com.example.baitaptuan2.service;


import com.example.baitaptuan2.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll() ;
    Employee addEmployee(Employee employee) ;
    boolean deleteEmployee(List<Integer> employeeIds) ;
    boolean deleteEmployeeSingle(Integer employeeId) ;
    Employee updEmployee(Employee employee) ;
}
