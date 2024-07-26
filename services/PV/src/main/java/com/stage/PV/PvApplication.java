package com.stage.PV;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PvApplication {

	public static void main(String[] args) {

		SpringApplication.run(PvApplication.class, args);

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode("john");
		System.out.println(hashedPassword);
	}

}
