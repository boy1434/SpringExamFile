package com.cos.newsexam.batch;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cos.newsexam.domain.NewsExam;
import com.cos.newsexam.domain.NewsExamRepository;
import com.cos.newsexam.util.CrawExam;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class NewsExamBatch {

	private final NewsExamRepository newsExamRepository;
	private final CrawExam CrawExam;
	
	// 초 분 시 일 월 요일  
		//@Scheduled(cron = "0 2 * * * *", zone = "Asia/Seoul") // 매일 15시 35분 Asia/Seoul = 표준시
	    @Scheduled(fixedDelay = 1000*60*1)
		public void newsCrawAndSave() {
	    	
	    	List<NewsExam> newsExamList = CrawExam.collect5();
	    	
	    	newsExamRepository.saveAll(newsExamList);
			
		}
}
