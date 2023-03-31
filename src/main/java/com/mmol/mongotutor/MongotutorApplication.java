package com.mmol.mongotutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
@EnableMongoRepositories
public class MongotutorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongotutorApplication.class, args);
	}

}
