package com.example.baitaptuan2.Entity;

import org.springframework.stereotype.Component;

@Component
public class Employee {
    static Integer ID=123783782;
    private Integer employeeId ;
    private String employeeName ;
    private String employeeEmail;
    private String employeePhone ;
    private String employeeAddress ;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }
    public Employee(){
        this.employeeId = ID++ ;
    }

    public Employee(String employeeName, String employeeEmail, String employeePhone, String employeeAddress) {
        this.employeeId = ID++ ;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.employeePhone = employeePhone;
        this.employeeAddress = employeeAddress;
    }
}
