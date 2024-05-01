package com.example.baitaptuan7.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data@Builder
@AllArgsConstructor@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
    @Id@GeneratedValue(strategy = GenerationType.UUID)
    String employeeId ;
    String employeeName ;
    String employeeEmail ;
    String employeePhone ;
    @ManyToOne @JoinColumn(name = "company_id")
    Company company ;

    @OneToMany(mappedBy = "employee" , cascade = CascadeType.ALL)
            @JsonIgnore
    List<Job> jobs ;

}
