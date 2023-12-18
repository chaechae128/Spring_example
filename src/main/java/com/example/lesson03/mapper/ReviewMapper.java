package com.example.lesson03.mapper;

import org.springframework.stereotype.Repository;

import com.example.lesson03.domain.Review;

@Repository
public interface ReviewMapper {
	
	//input:id
	//output:
	public Review selectReviewById(int id);
}
