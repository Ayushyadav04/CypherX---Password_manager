package com.password.Pass_login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class PassLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassLoginApplication.class, args);
	}

}
