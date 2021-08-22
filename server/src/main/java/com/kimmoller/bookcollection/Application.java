package com.kimmoller.bookcollection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Autowired
	private BookCollection bookCollection;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public void init() {
		System.out.println("init()");
		bookCollection.initCollection();
	}
}
