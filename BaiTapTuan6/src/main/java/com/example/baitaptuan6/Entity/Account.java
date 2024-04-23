package com.example.baitaptuan6.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {
    @Id
            @GeneratedValue(strategy = GenerationType.UUID)
    String accountId ;
    @Column(columnDefinition = "varchar(100)" , unique = true)
    String username ;
    String password ;
}
