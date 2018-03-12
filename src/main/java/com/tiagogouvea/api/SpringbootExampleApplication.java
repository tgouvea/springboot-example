package com.tiagogouvea.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringbootExampleApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootExampleApplication.class, args);
	}
	
}
