package com.pavanbhat.newspringdevelopment.service;

import com.pavanbhat.newspringdevelopment.MyFirstClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    private  final MyFirstClass myFirstClass;


    @Value("${custom.property.value}")
    private String customProperty;


    public MyFirstService(@Qualifier("mySecondClass") MyFirstClass myFirstClass){
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory(){
        return "The Dependy is saying : " + myFirstClass.sayHello();
    }

    public String getCustomProperty() {
        return customProperty;
    }
}
