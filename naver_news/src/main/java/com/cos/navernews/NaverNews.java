package com.cos.navernews;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection =  "naver_news")
@Data
public class NaverNews {
	@Id
	private String _id;
	private String title;
}
