package com.cos.navernews.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.navernews.domain.NaverNewsExam;
import com.cos.navernews.domain.NaverNewsExamRepository;



import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor
@RestController
public class NaverNewsExamController {
	private final NaverNewsExamRepository naverNewsExamRepository;
	
	@CrossOrigin
	@GetMapping(value = "/news" , produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<NaverNewsExam> findAll(){

		return naverNewsExamRepository.mFindAll()
				.subscribeOn(Schedulers.boundedElastic() );
	}
	
	@PostMapping("/news")
	public Mono<NaverNewsExam> save(@RequestBody NaverNewsExam naverNewsExam){
		return naverNewsExamRepository.save(naverNewsExam);
	}
}
