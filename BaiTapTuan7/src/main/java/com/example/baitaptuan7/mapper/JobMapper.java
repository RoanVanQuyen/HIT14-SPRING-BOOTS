package com.example.baitaptuan7.mapper;

import com.example.baitaptuan7.dto.request.JobRequest;
import com.example.baitaptuan7.entity.Job;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface JobMapper {
    Job toJob(JobRequest request) ;
    void updJob(@MappingTarget Job job , JobRequest request) ;
}
