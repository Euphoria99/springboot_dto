package com.pavanbhat.newspringdevelopment;

import com.pavanbhat.newspringdevelopment.service.MyFirstService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class NewspringdevelopmentApplication {

	public static void main(String[] args) {
		var app = new SpringApplication(NewspringdevelopmentApplication.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "dev"));
		var ctx = app.run(args);

		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
		System.out.println(myFirstService.tellAStory());
		System.out.println("The custom property from file : " + myFirstService.getCustomProperty());
	}
}
