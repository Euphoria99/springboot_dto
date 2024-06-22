package com.pavanbhat.newspringdevelopment.service;

import com.pavanbhat.newspringdevelopment.MyFirstClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    @Autowired
    @Qualifier("mySecondClass")
    private  MyFirstClass myFirstClass;

    public String tellAStory(){
        return "The Dependy is saying : " + myFirstClass.sayHello();
    }
}
