package com.example.lesson04.bo;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {

	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private StudentRepository studentRepository;
	
	//JPA로 insert
	public StudentEntity addStudent (String name, String phoneNumber, String email, String dreamJob) {
		//entity객체를 만들어야함 > JPA로 넘기기
		
		StudentEntity student = StudentEntity.builder()
								.name(name)
								.phoneNumber(phoneNumber)
								.email(email)
								.dreamJob(dreamJob)
								.createdAt(ZonedDateTime.now()) //@UpdateTimestamp가 있으면 생략 가능 다만, 내가 createdAt을 직접 넣고 싶을 떄
								.build(); //마무리 단계
		
		
		return studentRepository.save(student);//save(entity)
	}
	
	
	
	//-----Mybatis로 insert-----------------
	
	//input : 파라미터들 output: x
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	//input: id output: Student
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
		
	}
}
