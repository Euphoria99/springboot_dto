package com.pavanbhat.newspringdevelopment;

import com.pavanbhat.newspringdevelopment.service.MyFirstService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewspringdevelopmentApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(NewspringdevelopmentApplication.class, args);

		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
		System.out.println(myFirstService.tellAStory());
		System.out.println("The Backend technology used as per custom properties file : " + myFirstService.getCustomPropertyFromAnotherFile());
	}
}
