package com.pavanbhat.newspringdevelopment.config;

import com.pavanbhat.newspringdevelopment.MyFirstClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean("myBean")
    public MyFirstClass myFirstClass(){
        return new MyFirstClass();
    }
}
