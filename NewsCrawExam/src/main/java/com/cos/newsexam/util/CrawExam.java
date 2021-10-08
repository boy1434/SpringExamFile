package com.cos.newsexam.util;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cos.newsexam.domain.NewsExam;



@Component

public class CrawExam {
	
	 int aidNum = 1;
	
	public List<NewsExam> collect5(){
		RestTemplate rt = new RestTemplate();	
		List<NewsExam> newsExamList = new ArrayList<>();
		
		for (int i = 1; i < 6; i++) {
			String aid = String.format("%010d", aidNum);
			String url = "https://news.naver.com/main/read.naver?mode=LSD&mid=shm&sid1=102&oid=022&aid="+ aid;	
			String html = rt.getForObject(url, String.class);
			
			Document doc = Jsoup.parse(html);
			
			Element titleElement = doc.selectFirst("#articleTitle");
			Element timeElement = doc.selectFirst(".t11");
			Element Element = doc.selectFirst(".press_logo");
			
			
			
			
			String title = titleElement.text();
			String createdAt = timeElement.text();
			String company = Element.attr("title");
			System.out.println(titleElement);
			System.out.println(company);
			
			// System.out.println(title);
			// System.out.println(time);
			
			NewsExam newsExam = NewsExam.builder()
					.company(company)
					.title(title)
					.createdAt(createdAt)
					.build();
			
			newsExamList.add(newsExam);
			
			aidNum ++;
			
		}
		return newsExamList;
	}
}
