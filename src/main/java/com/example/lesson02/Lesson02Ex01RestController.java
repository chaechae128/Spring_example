package com.example.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.bo.UsedGoodsBO;
import com.example.lesson02.domain.UsedGoods;

@RestController//JSON으로 나옴
public class Lesson02Ex01RestController {
	
	@Autowired //DI: 스프링 빈 주입
	private UsedGoodsBO usedGoodsBO;
	// url: http://localhost:8008/lesson02/ex01
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> ex01(){ //map은 얼마든지put이 가능하고 안에 뭐가 들어있는지 몰라서DB와 어긋날 수 있음 그래서! 테이블명으로 
		
		return usedGoodsBO.getUsedGoodsList(); // response => JSON
		
	}
}
