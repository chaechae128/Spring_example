package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;
import com.example.lesson02.mapper.UsedGoodsMapper;

@Service //Spring bean
public class UsedGoodsBO {
	
	//BO는 레파지토리인 UsedGoodsMapper얘가 필요함
	@Autowired //Dependency Injection(DI) : 의존성 주입 <- Springbean을 new 할수 없어서 @Autowired얘를 통해 Springbean을 가져옴
	private UsedGoodsMapper usedGoodsMapper;
	
	//메소드 만들기!
	//input:x <-controller로부터 받아옴	
	//output: (Repository로부터 받은 것을)List<UsedGoods>  <-이걸 controller에게 주는거임
	public List<UsedGoods> getUsedGoodsList() { //getUsedGoods인데 여러 행이면 List이다
		return usedGoodsMapper.selectUsedGoodsList();
		
	}
	
}
