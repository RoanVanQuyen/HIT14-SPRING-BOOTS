package com.example.baitaptuan7.mapper;

import com.example.baitaptuan7.dto.request.EmployeeRequest;
import com.example.baitaptuan7.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee toEmployee(EmployeeRequest request) ;
    void updEmployee (@MappingTarget Employee employee , EmployeeRequest request) ;
}
