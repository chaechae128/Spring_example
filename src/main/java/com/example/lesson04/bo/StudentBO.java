package com.example.lesson04.bo;

import java.time.ZonedDateTime;
import java.util.Optional;

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
	
	
	//JPA로 update
	public StudentEntity updateStudentDreamjob (int id, String dreamJob) {
		//id가 이미 있으면 update구나
		//id가 없으면 insert구나
		
		//select   orElse:find를 해서 가져왔을 때 가져온 값이null 이라면 뭘로 정의할지? 정하는 것 ex) null
		StudentEntity student = studentRepository.findById(id).orElse(null);
		
		//update -> save
		if (student != null) { //student가 null 이 아닐 떄
			student = student.toBuilder() //기존 필드 값들은 유지하고 일부 필드만 변경 - toBuilder
			.dreamJob(dreamJob)
			.build(); // ★★★반드시 다시 저장한다!!★★★
		}
		
		student = studentRepository.save(student);
		
		return student; //student or null
	}
	
	
	//JPA로 delete
	public void deleteStudentById(int id) {
		//select 후에 delete해야함
		
		//방법 1)
//		StudentEntity student = studentRepository.findById(id).orElse(null);
		
		//delete
//		if(student != null ) {
//			studentRepository.delete(student);
//		}
		
		//방법 2) 
		//Optional :null 검사 생략
		Optional<StudentEntity> studentOptional = studentRepository.findById(id);
		//delete
		studentOptional.ifPresent(s -> studentRepository.delete(s)); //s가 있다면 -> 삭제해
		
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
