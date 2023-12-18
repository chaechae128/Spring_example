package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mapper.ReviewMapper;

@Service
public class ReviewBO {
	@Autowired
	private ReviewMapper reviewMapper;
	
	
	//input: id
	//output: Review
	public Review getReviewById(int id) { // 만약 request로 id 값이 null 로 오면 BO쪽에서 null인걸 받을 수 없어서 에러
		return  reviewMapper.selectReviewById(id);
	}
}
