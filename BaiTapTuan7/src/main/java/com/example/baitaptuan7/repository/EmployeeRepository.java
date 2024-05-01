package com.example.baitaptuan7.repository;

import com.example.baitaptuan7.entity.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee , String> {
    List<Employee> findEmployeeByEmployeeNameContainingIgnoreCase(String name , Pageable pageable) ;
}
