package com.example.demo;

import com.example.demo.models.Author;
import com.example.demo.models.Resource;
import com.example.demo.models.Video;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.VideoRepository;
import com.example.demo.specification.AuthorSpecification;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class DemoForSpringDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoForSpringDataApplication.class, args);
	}

	@Bean
	@Transactional
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

			//updating author with ID=1
			var author = Author.builder()
					.id(1)
					.firstName("Pavan")
					.lastName("Bhat")
					.email("pavanbhat@gmail.com")
					.age(25)
					.build();

//			repository.save(author);


			//update author a set a.age = 22 where a.id = 1
//			repository.updateAgeAuthor(22, 1);

			//update all authors
//			repository.updateAgeofAllAuthor(55);

//			repository.findByNamedQuery(26).forEach(System.out::println);

//			repository.updateByNamedQuery(27);

			//specification implementation

			Specification<Author> spec = Specification
										.where(AuthorSpecification.hasAge(35))
												.and(AuthorSpecification.firstNameLike("Ca"));

//			System.out.println("Has Age and First Name Like");
//			repository.findAll(spec).forEach(System.out::println);

			Specification<Author> spec2 = Specification
					.where(AuthorSpecification.firstNameLike("Ca"));

//			System.out.println("Has First Name Like");
//			repository.findAll(spec2).forEach(System.out::println);
		};

	}
}
