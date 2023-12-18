package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.domain.Review;

@RestController
public class Lesson03Ex01RestController {
	@Autowired
	private ReviewBO reviewBO;
	
	//url: http://localhost:8008/lesson03/ex01
	//url: http://localhost:8008/lesson03/ex01?id=7
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			//@RequestParam(value="id") int id // 필수 파라미터  굳이 뒤에 required이딴거 안 쓸거면 4번째 방식으로 
			//@RequestParam(value="id", required=true) int id // 필수 파라미터
			//@RequestParam(value = "id", required=false) Integer id //null가능 비필수 파라미터
			//@RequestParam(value="id", defaultValue = "1") int id//null일 수가 없음 비필수 + 디폴트 값이 1
			@RequestParam("id") int id // 필수 파라미터 
			
			) {
//		if (id == null) {
//			id = 1;
//		}
		return  reviewBO.getReviewById(id); //Response body JSON
	}
	
}
