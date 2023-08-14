package com.scaler.todolistwithdb;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodolistwithdbApplication {

	// Creates new Obj for Model Mapper, since java doesnt know how to create
	// 3-party dependency obj - This is dependency injection
	@Bean
	public ModelMapper ModelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(TodolistwithdbApplication.class, args);
	}

}
