package com.cos.navernews;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;

import reactor.core.publisher.Flux;

public interface NaverNewsRepository extends ReactiveMongoRepository<NaverNews, String>{
	
	@Tailable // 커서를 계속 열어두는 어노테이션 
	@Query("{}")
	Flux<NaverNews> mFindAll();

}
