package com.example.baitaptuan6.service;


import com.example.baitaptuan6.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll() ;
    Employee addEmployee(Employee employee) ;
    boolean deleteEmployee(List<String > employeeIds) ;
    boolean deleteEmployeeSingle(String  employeeId) ;
    Employee updEmployee(Employee employee) ;
}
