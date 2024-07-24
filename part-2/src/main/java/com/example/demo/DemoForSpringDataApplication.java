package com.example.demo;

import com.example.demo.models.Author;
import com.example.demo.models.Resource;
import com.example.demo.models.Video;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.VideoRepository;
import com.github.javafaker.Faker;
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
	public CommandLineRunner commandLineRunner(AuthorRepository repository, VideoRepository videoRepository){
		return  args -> {
			Faker faker = new Faker();
			for(int i=0;i < 50; i++ ){

//				String localPart = faker.internet().emailAddress().split("@")[0];
//				String emailWithCustomMailServer = localPart + "@gmail.com";

				var author = Author.builder()
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.email("randomGuy" + i + "@gmail.com")
						.age(faker.number().numberBetween(25,55))
						.build();
//				repository.save(author);
			}


/*			var video = Video.builder()
					.name("testName")
					.length(5)
					.build();
			videoRepository.save(video);*/

		};
	}
}
