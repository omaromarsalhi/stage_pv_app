package com.stage.insertMarks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class InsertMarksApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsertMarksApplication.class, args);
	}

}
