package com.example.OTT_show_resume_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"controller", "service", "repository", "pojos"})
@EnableMongoRepositories(basePackages = "repository")
public class OttShowResumeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OttShowResumeServiceApplication.class, args);
	}

}
