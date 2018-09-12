package net.slipp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import org.springframework.context.annotation.ComponentScan;

import net.slipp.web.WelcomeController;

@SpringBootApplication
public class MySlipp1Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MySlipp1Application.class, args);
	}
}
