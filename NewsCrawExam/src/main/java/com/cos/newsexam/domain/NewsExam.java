package com.cos.newsexam.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Document(collection = "naver_news")
@Data
public class NewsExam {
	@Id
	private String _id;
	
	private String company;  // 신문사 명
	private String title;          // 뉴스 제목
	private String createdAt; // 뉴스 발행일
	
	
	
}
