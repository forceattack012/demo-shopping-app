package com.forceattack012.domoShoppingApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DomoShoppingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomoShoppingAppApplication.class, args);
	}

}
