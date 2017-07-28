package br.com.sparkle.api.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"br.com.sparkle"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}