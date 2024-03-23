package com.example.baitaptuan1.model.modelIplm;

import com.example.baitaptuan1.model.StyleHair;
import org.springframework.stereotype.Component;

@Component
public class Undercut implements StyleHair {
    @Override
    public void out() {
        System.out.println("Đang để tóc Undercut");
    }
}
