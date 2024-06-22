package com.pavanbhat.newspringdevelopment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NewspringdevelopmentApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(NewspringdevelopmentApplication.class, args);

		MyFirstClass myFirstClass = ctx.getBean(MyFirstClass.class);
		System.out.println(myFirstClass.sayHello());
	}
}
