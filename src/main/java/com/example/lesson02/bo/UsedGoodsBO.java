package com.example.lesson02.bo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;

@Service //Spring bean
public class UsedGoodsBO {
	
	//메소드 만들기!
	//input:x <-controller로부터 받아옴	
	//output: (Repository로부터 받은 것을)List<UsedGoods>  <-이걸 controller에게 주는거임
	public List<UsedGoods> getUsedGoodsList() { //getUsedGoods인데 여러 행이면 List이다
		return ;
		
	}
	
}
