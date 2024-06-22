package com.pavanbhat.newspringdevelopment.service;

import com.pavanbhat.newspringdevelopment.MyFirstClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:custom.properties")
public class MyFirstService {

    private  MyFirstClass myFirstClass;

    @Value("${backend.tech}")
    private String customPropertyFromAnotherFile;

    public MyFirstService(@Qualifier("mySecondClass") MyFirstClass myFirstClass){
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory(){
        return "The Dependy is saying : " + myFirstClass.sayHello();
    }

    public String getCustomPropertyFromAnotherFile() {
        return customPropertyFromAnotherFile;
    }
}
