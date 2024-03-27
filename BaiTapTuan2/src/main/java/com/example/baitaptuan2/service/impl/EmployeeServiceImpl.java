package com.example.baitaptuan2.service.impl;

import com.example.baitaptuan2.Entity.Employee;
import com.example.baitaptuan2.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>() ;
    {
        employees.add(new Employee("Roãn Văn Quyền", "abc@gmail.com", "123456" , "Nam Dinh")) ;
        employees.add(new Employee("Roãn Văn Chuc", "pfadsuifjhfdas@gmail.com", "123456" , "Nam Dinh")) ;
        employees.add(new Employee("Bùi Thị Huê", "huebui@gmail.com", "123456" , "Nam Dinh")) ;
    }
    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employees.add(employee) ;
        return employee;
    }

    @Override
    public boolean deleteEmployee(List<Integer> employeeIds) {
        for(int i = 0 ; i< employees.size() ; i++){
            for(Integer id: employeeIds){
                if(employees.get(i).getEmployeeId().equals(id)){
                    employees.remove(employees.get(i)) ;
                }
            }
        }
        return true;
    }

    @Override
    public boolean deleteEmployeeSingle(Integer employeeId) {
        for(int i =0 ; i< employees.size() ; i++){
            if(employees.get(i).getEmployeeId().equals(employeeId)){
                employees.remove(employees.get(i)) ;
            }
        }
        return true;
    }

    @Override
    public Employee updEmployee(Employee employee) {
        for(Employee x : employees){
            if(x.getEmployeeId().equals(employee.getEmployeeId())){
                employees.remove(x) ;
                employees.add(employee) ;
                break;
            }
        }
        return employee;
    }
}
