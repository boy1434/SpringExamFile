package com.cos.navernews.util;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cos.navernews.domain.NaverNewsExam;

@Component
public class NaverExam {
	
	int aidNum = 277492;
	
	public List<NaverNewsExam> collect2(){
		RestTemplate rt = new RestTemplate();	
		List<NaverNewsExam> naverNewsList = new ArrayList<>();
		
		for (int i = 1; i < 3; i++) {
			String aid = String.format("%010d", aidNum);
			// 0000277493
			String url = "https://news.naver.com/main/read.naver?mode=LSD&mid=shm&sid1=103&oid=437&aid="+ aid;
			
			try {
			String html = rt.getForObject(url, String.class);
			Document doc = Jsoup.parse(html);	
			System.out.println(html);
			
			Element companyElement = doc.selectFirst(".press_logo img");
			String companyAttr = companyElement.attr("title");			
			Element titleElement = doc.selectFirst("#articleTitle");			
			Element createAtElement = doc.selectFirst(".t11");
			
			String company    = companyAttr;
			String title             =titleElement.text();
			String createdAt = createAtElement.text();
			System.out.println(title);
			// System.out.println(title);
			// System.out.println(time);
			
			NaverNewsExam nne = NaverNewsExam.builder()
					.title(title)
					.company(company)
					.createdAt(createdAt)
					.build();
			
			naverNewsList.add(nne);
			 } catch(Exception e){
			    	System.out.println("통신 오류");
			    }	
			aidNum ++;
			
		}
		return naverNewsList;
	}
}
