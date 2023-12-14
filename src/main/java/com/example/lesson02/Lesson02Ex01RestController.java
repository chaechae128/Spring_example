package com.example.lesson02;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.domain.UsedGoods;

@RestController
public class Lesson02Ex01RestController {
	
	// url: http://localhost/lesson02/ex01
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> ex01(){ //map은 얼마든지put이 가능하고 안에 뭐가 들어있는지 몰라서DB와 어긋날 수 있음 그래서! 테이블명으로 
		
		return ; // response => JSON
		
	}
}
