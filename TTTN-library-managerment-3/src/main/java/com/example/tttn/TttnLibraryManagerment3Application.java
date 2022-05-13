package com.example.tttn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TttnLibraryManagerment3Application {

	public static void main(String[] args) {
		SpringApplication.run(TttnLibraryManagerment3Application.class, args);
	}
	
}
