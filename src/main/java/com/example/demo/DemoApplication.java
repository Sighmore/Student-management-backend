package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A class to run the application
 * It is annotated with @SpringBootApplication: to indicate that it is a Spring Boot application
 * @SpringBootApplication is a convenience annotation that adds all of the following:
 * @Configuration: to indicate that it is a configuration class
 * @EnableAutoConfiguration: to enable auto-configuration
 * @ComponentScan: to enable component scanning
 */
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}


}
