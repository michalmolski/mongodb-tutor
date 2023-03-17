package com.mmol.mongotutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MongotutorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongotutorApplication.class, args);
	}

}
