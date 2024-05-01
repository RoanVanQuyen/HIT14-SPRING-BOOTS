package com.example.baitaptuan7.controller;

import com.example.baitaptuan7.dto.request.JobRequest;
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
@RequestMapping(value = "/job")
public class JobController {
    @Autowired
    @Qualifier(value = "jobServiceImplParent")
    ServiceParent<JobRequest> service ;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addCompany(@RequestBody JobRequest request){
        Response response = service.add(request) ;
        return ResponseEntity.status(response.getCode())
                .body(response) ;
    }

    @RequestMapping(value = "/{jobId}",method = RequestMethod.PUT)
    public ResponseEntity<?> updCompany(@PathVariable String jobId, @RequestBody JobRequest request){
        Response response = service.upd(jobId, request) ;
        return ResponseEntity.status(response.getCode())
                .body(response) ;
    }

    @RequestMapping(value = "/{jobIds}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delCompany(@PathVariable List<String> jobIds){
        Response response = service.delete(jobIds) ;
        return ResponseEntity.status(response.getCode())
                .body(response) ;
    }

    @RequestMapping(value = "/{jobId}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable String jobId){
        Response response = service.findById(jobId) ;
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
