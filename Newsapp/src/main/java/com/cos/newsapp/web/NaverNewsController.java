package com.cos.newsapp.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cos.newsapp.domain.NaverNewsRepository;
import com.cos.newsapp.web.dto.CMRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class NaverNewsController {

	private final NaverNewsRepository naverNewsRepository;
	
	@GetMapping("/naverNews")
	public CMRespDto<?> findAll() {
		
		
		return new CMRespDto<>(1,"성공", naverNewsRepository.findAll());
		
	}
}
