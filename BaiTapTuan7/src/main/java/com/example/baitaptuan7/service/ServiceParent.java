package com.example.baitaptuan7.service;

import com.example.baitaptuan7.dto.response.Response;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceParent<T> {
    Response add(T t) ;
    Response delete(List<String> requestId) ;
    Response upd(String id , T t) ;
    Response findById(String id) ;
    Response getAll(Pageable pageable) ;
}
