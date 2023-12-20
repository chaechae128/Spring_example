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
	//input: Review		output: 성공한 행의 개수(int)
	public int addReview(Review review) { 
		
		return reviewMapper.insertReview(review);
	}
	
	//addReviewAsField(4, "콤비네이션R", "바다", 5.0, "역시 맛있다!");  //순서도 맞아야됨
	public int addReviewAsField(int storeId, String menu, String userName, Double point, String review) {
		//자동완성을 믿지 말고 순서를 잘 봐여됨
		return reviewMapper.insertReviewAsField(storeId, menu, userName, point, review);
	}
	//input :id, review  output: 성공한 행의 개수
	public int updateReviewById(int id, String review) {
		return reviewMapper.updateReviewById(id, review);
	}
	
	//input: id		output: X
	public void deleteReviewById(int id) {
		reviewMapper.deleteReviewById(id);
	}
}
