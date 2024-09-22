package com.infnet.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataBaseApplication.class, args);
		System.out.println("Micro Database Application Started");
	}
}
