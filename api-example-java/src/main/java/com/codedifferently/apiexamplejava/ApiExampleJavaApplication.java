package com.codedifferently.apiexamplejava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiExampleJavaApplication {

	public static void main(String[] args) {
		try {
			System.setProperty("server.port", "8080");
			SpringApplication.run(ApiExampleJavaApplication.class, args);
		}
		catch(RuntimeException ex) {
			throw new RuntimeException(ex);
		}
	}

}
