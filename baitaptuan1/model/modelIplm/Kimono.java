package com.example.baitaptuan1.model.modelIplm;

import com.example.baitaptuan1.model.Clothes;
import org.springframework.stereotype.Component;

@Component
public class Kimono implements Clothes {
    @Override
    public void out() {
        System.out.println("Đang mặc Kimono");
    }
}
