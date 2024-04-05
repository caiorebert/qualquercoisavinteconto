package com.imd.qualquercoisa20conto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Qualquercoisa20contoApplication {
	@Bean
	public CommandLineRunner init(){
		return args -> {
			System.out.println("iniciando");
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Qualquercoisa20contoApplication.class, args);
	}

}
