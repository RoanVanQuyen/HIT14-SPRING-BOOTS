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
public class Company {
    @Id@GeneratedValue(strategy = GenerationType.UUID)
    String companyId ;
    String companyName ;
    @OneToMany(mappedBy = "company" , cascade = CascadeType.ALL)
            @JsonIgnore
    List<Employee> employees ;
}
