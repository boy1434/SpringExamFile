package com.cos.navernews.domain;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;

import reactor.core.publisher.Flux;

public interface NaverNewsExamRepository extends ReactiveMongoRepository<NaverNewsExam, String>{
	
	@Tailable // 커서를 계속 열어두는 어노테이션 
	@Query("{}")
	Flux<NaverNewsExam> mFindAll();

}
