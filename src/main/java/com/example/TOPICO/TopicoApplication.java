package com.example.TOPICO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class TopicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopicoApplication.class, args);
	}

}
