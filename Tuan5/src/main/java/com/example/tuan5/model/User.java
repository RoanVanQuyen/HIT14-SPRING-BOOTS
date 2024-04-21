package com.example.tuan5.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@NoArgsConstructor@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class User {
    @Builder.Default
    String accountId = UUID.randomUUID().toString();
    String username ;
    String password ;
}
