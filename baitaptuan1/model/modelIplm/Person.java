package com.example.baitaptuan1.model.modelIplm;

import com.example.baitaptuan1.model.Clothes;
import com.example.baitaptuan1.model.StyleHair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {
    @Autowired
    @Qualifier("kimono")
    private Clothes clothes ;
    @Autowired
    @Qualifier("undercut")
    private StyleHair styleHair ;
    public void out(){
        clothes.out();
        styleHair.out();
    }
}
