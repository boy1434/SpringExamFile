package com.cos.newsexam.web;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.newsexam.domain.NewsExam;
import com.cos.newsexam.domain.NewsExamRepository;
import com.cos.newsexam.web.dto.CMRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class NewsExamController {

   private final NewsExamRepository newsExamRepository;
   
   @GetMapping("/newsExam")
   public CMRespDto<List<NewsExam>> findAll(){
      return new CMRespDto<>(1, "성공", newsExamRepository.findAll());
   }
}