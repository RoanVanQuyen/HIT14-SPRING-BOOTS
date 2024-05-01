package com.example.baitaptuan7.controller;

import com.example.baitaptuan7.dto.request.CompanyRequest;
import com.example.baitaptuan7.dto.response.Response;
import com.example.baitaptuan7.service.ServiceParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/company")
public class CompanyController {
    @Autowired @Qualifier(value = "companyServiceImplParent")
    ServiceParent<CompanyRequest> service ;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addCompany(@RequestBody CompanyRequest request){
        Response response = service.add(request) ;
        return ResponseEntity.status(response.getCode())
                .body(response) ;
    }

    @RequestMapping(value = "/{companyId}" ,method = RequestMethod.PUT)
    public ResponseEntity<?> updCompany(@PathVariable String companyId , @RequestBody CompanyRequest request){
        Response response = service.upd(companyId , request) ;
        return ResponseEntity.status(response.getCode())
                .body(response) ;
    }

    @RequestMapping(value = "/{companyIds}" , method = RequestMethod.DELETE)
    public ResponseEntity<?> delCompany(@PathVariable List<String> companyIds){
        Response response = service.delete(companyIds) ;
        return ResponseEntity.status(response.getCode())
                .body(response) ;
    }

    @RequestMapping(value = "/{companyId}" , method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable String companyId){
        Response response = service.findById(companyId) ;
        return ResponseEntity.status(response.getCode())
                .body(response) ;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "1") int pageIndex,
                                     @RequestParam(defaultValue = "9") int pageSize ){
        Pageable pageable = PageRequest.of(pageIndex -1 , pageSize) ;
        Response response = service.getAll(pageable) ;
        return ResponseEntity.status(response.getCode())
                .body(response) ;
    }
}
