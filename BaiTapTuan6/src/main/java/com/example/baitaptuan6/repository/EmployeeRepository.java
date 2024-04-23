package com.example.baitaptuan6.repository;

import com.example.baitaptuan6.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee , String> {

    @Query("FROM Employee  e " +
            "WHERE e.employeeEmail=:email and e.employeeId != :id")
    List<Employee> checkUpdateEmail(String email , String id) ;
}
