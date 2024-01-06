package com.rocha.aws.app;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootAwsApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAwsApp1Application.class, args);
	}

	@Bean
	Function<String, String> uppercase() {
		return value -> value.toUpperCase();
	}

}
