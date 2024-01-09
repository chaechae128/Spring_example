package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.lesson07.entity.StudentEntity;

//@Transactional
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{

//	@PersistenceContext
//	private EntityManager em;
//	
//	public StudentEntity save(StudentEntity studentEntity) {
//		em.persist(studentEntity);
//		return studentEntity;
//	}
	
	
	
	
	// JPA, Spring Data JPA  <- 이 둘은 엄연히 다름
	//JPA : 메소드 정의를 다 따로따로 해줘야함 -> 불편
	//Spring Data JPA : JPA와 함께 사용 많이 쓰는 메소드들 사용할 수 있음 ex) 라이브러리 같은거
	//상속을 받아야함 JpaRepository<entity이름, entity의 PK 무슨 타입>
	
	
	//Sprint data JPA
	
	//엔티티 save(엔티티) 1. insert(id가 null)  2. update(id가 있음)
	//optional<엔티티객체> findById(id)
	//엔티티 FindById(id)    <- 이미 있는 것  만들필요 x
	//삭제 : void dlete(엔티티객체)
	//전체조회 : List<엔티티객체> findAll();
	
	//기본 제공이 아닌 바뀌는 메소드는 껍데기는 작성해줘야함
	
	//ex02/1 - JPQL
	public List<StudentEntity> findAllByOrderByIdDesc();
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	public List<StudentEntity> findByName(String name);
	public List<StudentEntity> findByNameIn(List<String> names);
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	public List<StudentEntity> findByEmailContaining(String email);
	public List<StudentEntity> findByNameStartingWith(String name);
	public List<StudentEntity> findByIdBetween(int startId, int endId);
	
	//ex02/2 - JPQL(Entity에 조회 db에 가지 않음 db에 접근은 jpa가)
	//@Query(value = "select st from StudentEntity st where st.dreamJob =:dreamJob") //JPQL문법(엔티티조회) 쿼리문이 아님 걍 비슷할 뿐
	@Query(value = "select * from new_student where dreamJob =:dreamJob" , nativeQuery = true)//nativeQuery : SQL문 조회  엔티티 조회x 
	public List<StudentEntity> findByDreamJob(@Param("dreamJob") String dreamJob);
	
	
	
}
