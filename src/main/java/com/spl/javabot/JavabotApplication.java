package com.spl.javabot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JavabotApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavabotApplication.class, args);
	}

}
