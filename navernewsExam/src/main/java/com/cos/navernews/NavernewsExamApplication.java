package com.cos.navernews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class NavernewsExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(NavernewsExamApplication.class, args);
	}

}
