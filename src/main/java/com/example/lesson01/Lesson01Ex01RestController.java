package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01")
@RestController // @Controller + @ResponseBody ResponseBody얘의 개념을 잘 알고 있어야됨
public class Lesson01Ex01RestController {
	
	//url: http://localhost:8008/lesson01/ex01/3
	@RequestMapping("/3")
	public String ex01_3() {
		return "@RestController 사용해 String을 리턴해본다.";
	}
	
	//url: http://localhost:8008/lesson01/ex01/4
	@RequestMapping("/4")
	public Map<String, String> ex01_4() {
		Map<String, String> map = new HashMap<>();
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		map.put("ddd", "444");
		return map;
	} 
	
	//url: http://localhost:8008/lesson01/ex01/5
	@RequestMapping("/5")
	public Data ex01_5() {
		Data data = new Data(); // 일반 자바 bean(객체)
		data.setId(10);
		data.setName("김채연");
		
		return data; // key-value가 있는걸 그냥 리턴할 때 일반 bean객체도 json으로 변환된다.  <- responsebody필요
		//list도 json
	}
	//url: http://localhost:8008/lesson01/ex01/6
	@RequestMapping("/6")
	public ResponseEntity<Data> ex01_6() {
		Data data = new Data();
		data.setId(11);
		data.setName("권지용");
		
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR); // OK:200 INTERNAL_SERVER_ERROR: 500
	}
	
	
}
