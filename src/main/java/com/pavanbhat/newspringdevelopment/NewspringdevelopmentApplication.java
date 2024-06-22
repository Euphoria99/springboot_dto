package com.pavanbhat.newspringdevelopment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewspringdevelopmentApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(NewspringdevelopmentApplication.class, args);

		MyFirstClass myFirstClass = ctx.getBean("myBean", MyFirstClass.class);
		System.out.println(myFirstClass.sayHello());
	}
}
