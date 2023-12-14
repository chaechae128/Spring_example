package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//JSP로 보내는 컨트롤러
@Controller  // @ResponseBody가 있으면 안 된다!!!(@RestController여도 안 된다!)
public class Lesson01Ex02Controller {
	
	//url: http://localhost:8008/lesson01/ex02
	//return되는 String은 jsp의 경로이다.(@ResponseBody이 없을 때)
	@RequestMapping("/lesson01/ex02")  //Request path 주소 
	public String ex02() {
		return "lesson01/ex02"; // Response view의 경로임 
		
		//spring.mvc.view.prefix=/WEB-INF/jsp/  <- 맨 앞에 이거 쓰임 이거 제외하고 쓰면 됨
		//spring.mvc.view.suffix=.jsp <- 맨 뒤에 이거 쓰임 이거 제외하고 쓰면 됨
	}
}
