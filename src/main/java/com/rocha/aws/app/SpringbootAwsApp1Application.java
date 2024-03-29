package com.rocha.aws.app;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rocha.aws.app.model.Book;
import com.rocha.aws.app.service.DataSerivice;

@SpringBootApplication
public class SpringbootAwsApp1Application {

	@Autowired
	private DataSerivice dataService;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAwsApp1Application.class, args);
	}

	@Bean
	Function<Book, Book> uppercase() {
		dataService.initDynamoDbClient();
		return value -> {
			return dataService.persistData(value);
		};
	}
}
