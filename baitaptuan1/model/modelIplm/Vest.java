package com.example.baitaptuan1.model.modelIplm;

import com.example.baitaptuan1.model.Clothes;
import org.springframework.stereotype.Component;

@Component
public class Vest implements Clothes {
    @Override
    public void out() {
        System.out.println("Đang mặc Vest");
    }
}
