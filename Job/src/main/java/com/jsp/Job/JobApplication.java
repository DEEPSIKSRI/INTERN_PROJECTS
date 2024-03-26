package com.jsp.Job;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobApplication {

	@Value("${name}")
	private String myName;

	public static void main(String[] args) {

		SpringApplication.run(JobApplication.class, args);
	}
}