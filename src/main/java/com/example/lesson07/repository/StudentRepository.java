package com.example.lesson07.repository;

import org.springframework.stereotype.Repository;

import com.example.lesson07.entity.StudentEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository	
public class StudentRepository {
	@PersistenceContext
	private EntityManager em;
	
	public StudentEntity save(StudentEntity studentEntity) {
		em.persist(studentEntity);
		return studentEntity;
	}

	
	
	// JPA, Spring Data JPA  <- 이 둘은 엄연히 다름
	//JPA : 메소드 정의를 다 따로따로 해줘야함 -> 불편
	//Spring Data JPA : JPA와 함께 사용 많이 쓰는 메소드들 사용할 수 있음 ex) 라이브러리 같은거
	//상속을 받아야함 JpaRepository<entity이름, entity의 PK 무슨 타입>
	
		
}
