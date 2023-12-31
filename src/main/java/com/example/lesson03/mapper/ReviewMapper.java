package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lesson03.domain.Review;

@Mapper
public interface ReviewMapper {
	
	//input:id 		//output:Review
	public Review selectReviewById(int id);
	
	//input: Review		output: 성공한 행의 개수(int)
	public int insertReview(Review review);
	
	public  int insertReviewAsField (
			//하나의 map 된 것 -> @Param
			@Param("storeId")int storeId, 
			@Param("menu")String menu, 
			@Param("userName")String userName, 
			@Param("point")Double point, 
			@Param("review")String review);
	public int updateReviewById(
			@Param("id")int id, 
			@Param("review")String review);
	
	//input: id		output: 성공한 행의 개수
	public int deleteReviewById(int id);
}
