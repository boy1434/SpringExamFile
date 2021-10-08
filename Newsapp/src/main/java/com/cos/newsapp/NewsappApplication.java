package com.cos.newsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling // cron 작동 시작 ( 정기적실행)
@SpringBootApplication
public class NewsappApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsappApplication.class, args);
	}

}
