package com.example.baitaptuan6.mapper;

import com.example.baitaptuan6.Entity.Account;
import com.example.baitaptuan6.request.AccountRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    Account toAccount(AccountRequest request) ;
}
