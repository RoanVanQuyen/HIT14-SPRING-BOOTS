package com.example.baitaptuan6.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor @NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
public class Employee {
    @Id
            @GeneratedValue(strategy = GenerationType.UUID)
    String employeeId ;
    String employeeName ;
    String employeeEmail;
    String employeePhone ;
    String employeeAddress ;
}
