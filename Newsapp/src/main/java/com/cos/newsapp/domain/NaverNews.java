package com.cos.newsapp.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
@Document(collection = "naver_news") 
public class NaverNews {

	@Id
	private String _id; // 몽고DB에 PK
	private String company;
	private String title;
	private String createAt; // 날짜를 몽고DB save() 하면 무조건 미국시간으로 들어감! + 9시간되서 들어감.
}
