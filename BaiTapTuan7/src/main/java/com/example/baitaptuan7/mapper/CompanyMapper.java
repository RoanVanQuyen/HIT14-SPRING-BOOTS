package com.example.baitaptuan7.mapper;

import com.example.baitaptuan7.dto.request.CompanyRequest;
import com.example.baitaptuan7.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    Company toCompany(CompanyRequest request) ;
    void updateCompany(@MappingTarget Company company , CompanyRequest request) ;
}
