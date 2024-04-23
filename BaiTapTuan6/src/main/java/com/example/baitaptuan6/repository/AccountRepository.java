package com.example.baitaptuan6.repository;

import com.example.baitaptuan6.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository extends JpaRepository<Account , String> {
    boolean existsByUsername(String username) ;
    boolean existsByUsernameAndPassword(String username , String password) ;
}
