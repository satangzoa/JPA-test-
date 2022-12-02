package com.pengsoo.hom.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//JPA
@Entity//MemberDto 클래스를 Entity로 선언
@Table(name = "jpa_table2") // 엔티티와 매핑할 테이블 이름을 지정

//lombok
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberDto {
	
	@Id // 매핑된 테이블의 기본키에 해당하는 속성위에 선언. 
	@Column(name = "hakbun")//테이블의 필드와 매핑
	@GeneratedValue(strategy = GenerationType.AUTO ) // 기본키 생성 전략.@GeneratedValue는 데이터베이스 생성 위임. GenerationType.AUTO는 시퀀스 생성
	private Long hakbun; // 학번 기본키
	
	@Column(name = "name", nullable = false, length = 20) //이름값 null 아니게한다. nullable -> null 값 허용 여부
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "grade")
	private int grade; // 학년
	
	@Column(name = "etc", length = 50)
	private String etc; // 기타 학생 비고 설명
}
