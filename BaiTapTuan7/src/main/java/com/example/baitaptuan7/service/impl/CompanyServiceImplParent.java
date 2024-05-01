package com.example.baitaptuan7.service.impl;

import com.example.baitaptuan7.dto.request.CompanyRequest;
import com.example.baitaptuan7.dto.response.Response;
import com.example.baitaptuan7.entity.Company;
import com.example.baitaptuan7.mapper.CompanyMapper;
import com.example.baitaptuan7.repository.CompanyRepository;
import com.example.baitaptuan7.service.ServiceParent;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CompanyServiceImplParent implements ServiceParent<CompanyRequest> {
    @Autowired
    CompanyRepository companyRepository ;
    @Autowired
    CompanyMapper companyMapper ;


    @Override
    public Response add(CompanyRequest companyRequest) {
        Company company = companyMapper.toCompany(companyRequest) ;
        company = companyRepository.save(company) ;
        return Response.builder()
                .code(201)
                .result(company)
                .message("Thêm thành công 'Company' ")
                .build();

    }

    @Transactional
    @Override
    public Response delete(List<String> requestId) {
        List<Company> companies = new ArrayList<>() ;
        for(String x : requestId){
            Optional<Company> companyOptional = companyRepository.findById(x) ;
            if(companyOptional.isPresent()){
                companies.add(companyOptional.get()) ;
                companyRepository.delete(companyOptional.get());
            }
        }
        return Response.builder()
                .code(200)
                .result(companies)
                .message("Xoá thành công danh sách ' Company' ")
                .build();
    }

    @Override
    public Response upd(String id , CompanyRequest companyRequest) {
        Company company = companyRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Không tồn tại 'Company' ")
        );
        companyMapper.updateCompany(company,companyRequest);
        company = companyRepository.save(company) ;
        return Response.builder()
                .code(200)
                .message("Cập nhập thành công")
                .result(company)
                .build();
    }

    @Override
    public Response findById(String id) {
        Company company = companyRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Không tồn tại 'Company' ")
        );
        return Response.builder()
                .code(200)
                .message("Tìm kiếm thành công")
                .result(company)
                .build();
    }

    @Override
    public Response getAll(Pageable pageable) {
        return Response.builder()
                .code(200)
                .result(companyRepository.findAll(pageable))
                .message("Tìm kiếm thành công")
                .build();
    }
}
