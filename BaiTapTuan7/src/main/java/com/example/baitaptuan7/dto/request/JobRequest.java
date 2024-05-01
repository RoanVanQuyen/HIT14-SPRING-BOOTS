package com.example.baitaptuan7.dto.request;

import com.example.baitaptuan7.entity.Employee;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobRequest {
    String jobName ;
    Employee employee ;
}
