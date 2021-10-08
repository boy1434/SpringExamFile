package com.cos.newsapp.batch;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cos.newsapp.domain.NaverNews;
import com.cos.newsapp.domain.NaverNewsRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class NaverNewsCrawBatch {

	private final NaverNewsRepository naverNewsRepository;
	private int aid =1; 
	
	@Scheduled(fixedDelay = 1000*60*1)
	public void newsCraw() {

		List<NaverNews> newsList = new ArrayList<>();
		
			
		for (int i = 0; i < 5; i++) {
			
		
			String aidStr = String.format("%010d", aid);
			String url ="https://news.naver.com/main/read.naver?mode=LSD&mid=shm&sid1=102&oid=022&aid="+aidStr;
			RestTemplate rt = new RestTemplate();
			
			try {
			String html = rt.getForObject(url, String.class);
			Document doc = Jsoup.parse(html);	
			
			Element companyElement = doc.selectFirst(".press_logo img");
			String companyAttr = companyElement.attr("title");			
			Element titleElement = doc.selectFirst("#articleTitle");			
			Element createAtElement = doc.selectFirst(".t11");
			
			String company    = companyAttr;
			String title             =titleElement.text();
			String createdAt = createAtElement.text();
			
			NaverNews nn = NaverNews.builder()
					.title(title)
					.company(company)
					.createAt(createdAt)
					.build();
			
			newsList.add(nn);
			
		    } catch(Exception e){
		    	System.out.println("통신 오류");
		    }	
		    	aid ++;
		}	 // end of For

				

	
			
			naverNewsRepository.saveAll(newsList); // 벌크 컬렉터
		} // end of newsCraw()
		
} 

