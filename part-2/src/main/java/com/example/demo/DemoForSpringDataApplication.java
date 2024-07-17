package com.example.demo;

import com.example.demo.models.Author;
import com.example.demo.repository.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoForSpringDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoForSpringDataApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AuthorRepository repository){
		return  args -> {
			var author = Author.builder()
					.firstName("Pavan")
					.lastName("Bhat")
					.email("pavanbhat@gmail.com")
					.age(25)
					.build();

			repository.save(author);
		};
	}
}
