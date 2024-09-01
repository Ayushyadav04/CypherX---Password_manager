package com.add_pass.add_pass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class AddPassApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddPassApplication.class, args);
	}

}
