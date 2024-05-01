package com.example.baitaptuan7.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data@Builder
@AllArgsConstructor@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Job {
    @Id@GeneratedValue(strategy = GenerationType.UUID)
    String jobId ;
    String jobName ;
    @ManyToOne()
            @JoinColumn(name = "employee_id")
    Employee employee ;

}
