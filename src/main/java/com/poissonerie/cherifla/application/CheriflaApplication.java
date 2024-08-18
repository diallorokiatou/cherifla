package com.poissonerie.cherifla.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.poissonerie.cherifla")
public class CheriflaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheriflaApplication.class, args);
	}

}
