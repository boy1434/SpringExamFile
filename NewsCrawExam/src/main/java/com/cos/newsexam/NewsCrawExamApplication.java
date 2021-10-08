package com.cos.newsexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class NewsCrawExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsCrawExamApplication.class, args);
	}

}
