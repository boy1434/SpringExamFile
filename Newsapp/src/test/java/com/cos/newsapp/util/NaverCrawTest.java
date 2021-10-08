package com.cos.newsapp.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

public class NaverCrawTest {
	
	int aid =1 ;
	
	@Test
	public void test1() {
		
		String aidStr = String.format("%010d", aid);
		String url ="https://news.naver.com/main/read.naver?mode=LSD&mid=shm&sid1=102&oid=022&aid="+aidStr;
		
		RestTemplate rt = new RestTemplate();
		
		String html = rt.getForObject(url, String.class);
		System.out.println(html);
		
		Document doc = Jsoup.parse(html);
		
		Element companyElement = doc.selectFirst(".press_logo img");
		String companyAttr = companyElement.attr("title");
		
		Element titleElement = doc.selectFirst("#articleTitle");
		
		Element createAtElement = doc.selectFirst(".t11");
		
		String company    = companyAttr;
		String title             =titleElement.text();
		String createdAt = createAtElement.text();
	}

}
