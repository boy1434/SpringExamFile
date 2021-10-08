package com.cos.navernews.batch;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cos.navernews.domain.NaverNewsExam;
import com.cos.navernews.domain.NaverNewsExamRepository;
import com.cos.navernews.util.NaverExam;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class NaverNewsExamBatch {

	private final NaverNewsExamRepository naverNewsExamRepository;
	private final NaverExam NaverExam;
	
	// @Scheduled(cron = "0 0 1 * * *", zone = "Asia/Seoul") // 매일 15시 35분 Asia/Seoul = 표준시
	@Scheduled(fixedDelay = 1000*60*1)
	public void naverNewsExamSave() {
		
		List<NaverNewsExam> naverNewsExamList = NaverExam.collect2();
		
		naverNewsExamRepository.saveAll(naverNewsExamList);
	}
}
