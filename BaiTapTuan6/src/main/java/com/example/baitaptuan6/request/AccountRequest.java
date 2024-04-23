package com.example.baitaptuan6.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@AllArgsConstructor@NoArgsConstructor
@Data
@Builder
public class AccountRequest {
    private String username ;
    private String password ;
    private String passwordConfirm ;
}
