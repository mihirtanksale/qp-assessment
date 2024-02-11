package com.questionpro.grocery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GroceryApplication {
	public static void main(String[] args) {
		SpringApplication.run(GroceryApplication.class, args);
	}

}
