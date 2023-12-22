package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.domain.Student;

@RequestMapping("/lesson04/ex02")
@Controller
public class Lesson04Ex02Controller {
	@Autowired
	private StudentBO studentBO;
	//학생 추가 화면
	//url: http://localhost:8008/lesson04/ex02/add-student-view
	@GetMapping("/add-student-view")
	public String addStudentView() {		
		return "lesson04/addStudent";
	}
	
	//방금 가입 된 학생 화면 & DB insert
	@PostMapping("/add-student")
	public String addStudent(
			@ModelAttribute Student student,//@ModelAttribute 생략 가능하지만 붙이는 게 좋음
			// 태그의 name 속성 파라미터와 이름이 같은 필드에 매핑 
			//실무에서는 @RequestParam으로 함
			Model model){
		
		//DB insert
		studentBO.addStudent(student); //아까 id값 받도록 했는데 그 id는 student에 들어가있음
		//DB에서 방금 가입된 사용자 select
		int id = student.getId();
		student = studentBO.getStudentById(id);
		
		//그 가져온 데이터를 model에 담는다(jsp에서 사용하도록)
		model.addAttribute("student", student);
		model.addAttribute("title", "방금 가입된 사용자 정보");
		
		//화면뿌리기 => table로
		return "lesson04/afterAddStudent";
	}
}
