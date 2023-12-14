package com.example.lesson02.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.lesson02.domain.UsedGoods;

@Repository
public interface UsedGoodsMapper { //interface는 객체가 안 됨 new못 함 알아서 객체를 만듦
	
	//input : x (BO로 부터 받아오는 것)
	//output : (database로부터 받은) List<UsedGoods> (를 Service에게 줌)
	public List<UsedGoods> selectUsedGoodsList();
}
