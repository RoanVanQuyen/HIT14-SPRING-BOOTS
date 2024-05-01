package com.example.baitaptuan7.service.impl;

import com.example.baitaptuan7.dto.request.JobRequest;
import com.example.baitaptuan7.dto.response.Response;
import com.example.baitaptuan7.entity.Job;
import com.example.baitaptuan7.mapper.JobMapper;
import com.example.baitaptuan7.repository.JobRepository;
import com.example.baitaptuan7.service.ServiceParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImplParent implements ServiceParent<JobRequest> {
    @Autowired
    JobMapper jobMapper ;
    @Autowired
    JobRepository jobRepository ;
    @Override
    public Response add(JobRequest jobRequest) {
        Job job = jobMapper.toJob(jobRequest) ;
        job = jobRepository.save(job) ;
        return Response.builder()
                .code(200)
                .message("Thêm thành công")
                .result(job)
                .build();
    }

    @Override
    public Response delete(List<String> requestId) {
        List<Job> jobs = new ArrayList<>() ;
        for(String x : requestId){
            Optional<Job> jobOptional = jobRepository.findById(x) ;
            if(jobOptional.isPresent()){
                jobs.add(jobOptional.get()) ;
                jobRepository.delete(jobOptional.get());
            }
        }
        return Response.builder()
                .code(200)
                .result(jobs)
                .message("Xoá thành công danh sách ' Company' ")
                .build();
    }

    @Override
    public Response upd(String id , JobRequest jobRequest) {
        Job job = jobRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Không tồn tại Công việc này")
        ) ;
        jobMapper.updJob(job , jobRequest);
        job = jobRepository.save(job) ;
        return Response.builder()
                .result(job)
                .message("Cập nhập thành công 'Job' ")
                .code(200)
                .build();
    }

    @Override
    public Response findById(String id) {
        Job job = jobRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Không tồn tại Công việc này")
        ) ;
        return  Response.builder()
                .code(200)
                .result(job)
                .message("Tìm kiếm thành công")
                .build() ;
    }


    @Override
    public Response getAll(Pageable pageable) {
        return Response.builder()
                .code(200)
                .result(jobRepository.findAll(pageable))
                .message("Tìm kiếm thành công")
                .build();
    }
}
