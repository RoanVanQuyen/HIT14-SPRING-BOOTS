package com.example.baitaptuan6.service.impl;


import com.example.baitaptuan6.Entity.Account;
import com.example.baitaptuan6.mapper.AccountMapper;
import com.example.baitaptuan6.repository.AccountRepository;
import com.example.baitaptuan6.request.AccountRequest;
import com.example.baitaptuan6.response.Response;
import com.example.baitaptuan6.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository ;
    @Autowired
    AccountMapper mapper ;
    @Override
    public Response signUp(AccountRequest request) {
        if(!request.getPassword().equals(request.getPasswordConfirm())){
            return Response.builder()
                    .code(400)
                    .message("Mật khẩu nhập lại chưa trùng khớp")
                    .build();
        }
        if(accountRepository.existsByUsername(request.getUsername())){
            return Response.builder()
                    .code(400)
                    .message("Tên đăng nhập đã tồn tại")
                    .build() ;
        }
        Account account = Account.builder().build() ;
        account = mapper.toAccount(request) ;
        return Response.builder()
                .code(200)
                .result(accountRepository.save(account))
                .message("thanh cong")
                .build() ;
    }

    @Override
    public Response signIn(String username, String password) {
        if(accountRepository.existsByUsernameAndPassword(username, password)){
            return Response.builder()
                    .code(200)
                    .message("Đăng nhập thành công")
                    .build() ;
        }
        return Response.builder()
                .code(400)
                .message("Sai tên đăng nhập hoặc mật khẩu")
                .build() ;
    }
}
