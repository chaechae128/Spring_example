package com.example.lesson07.entity;

import java.time.ZonedDateTime;
import java.util.Date;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString  //객체 출력 시 필드 값이 보여진다. //이 안에 있는 값을 예쁘게 뿌려줌 없어도 되지만 있으면 좋음  
@AllArgsConstructor //모든 필드가 파라미터로 있는 생성자
@NoArgsConstructor //파라미터가 없는 생성자
@Builder(toBuilder = true) //@Builder 이건 초기 세팅만 가능함 -> toBuilder가 true라면  필드값 변경 허용
@Getter
@Table(name = "new_student") //이걸 안 쓰면 StudentEntity이게 테이블 명인줄 알고 있음 그래서 테이블 명 명시
@Entity //이 객체는 엔티티다. (JPA - DB) 둘이 소통할 때 이 객체를 가지고 함
public class StudentEntity {
	
	@Id  //jakarta로 import
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // PK
	private int id;
	
	private String name;
	
	@Column(name = "phoneNumber")//카멜에다가는 어노테이션 걸어야됨
	private String phoneNumber;
	
	private String email;
	
	@Column(name = "dreamJob")
	private String dreamJob;
	
	@UpdateTimestamp //createdAt에 세팅을 안 하고 null로 되어있더라도 현재시간으로 저장
	@Column(name = "createdAt", updatable = false) //업데이트 시 변경되지 않도록 설정
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private Date updatedAt;
}
