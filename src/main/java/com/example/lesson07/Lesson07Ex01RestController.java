package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {
	@Autowired
	private StudentBO studentBO;
	
	@Autowired
	private StudentRepository studentRepository;
	
	//c: create
	@GetMapping("/1")
	public StudentEntity create() {
		String name = "김바다";
		String phoneNumber ="010-1111-2222";
		String email = "bada@naver.com";
		String dreamjob = "개발자";
		 //방금 insert된 PK id도 바로 얻어낼 수 있음
		return studentBO.addStudent(name, phoneNumber, email, dreamjob);
	}
	
	//u:update
	@GetMapping("/2")
	public StudentEntity update() {
		//id 가 5번인 dreamjob 변경
		//5, 손흥민->디자이너
		
		return studentBO.updateStudentDreamjob(5, "디자이너");
	}
	
	//d: delete
	@GetMapping("/3")
	public String delete() {
		//id가 7번인 학생 삭제
		studentBO.deleteStudentById(7);
		
		
		return "삭제완료";
	}
}
