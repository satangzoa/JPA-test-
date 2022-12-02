package com.pengsoo.hom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pengsoo.hom.dto.MemberDto;

public interface MemberRepository extends JpaRepository<MemberDto, Long>{ // 엔티티의 클래스 타입, 기본키 타입> MemberRepository는 dao 역할

	public List<MemberDto> findByName(String memberName); //이름을 검색해라 두명이상 검색될 확률이 있으므로 List<MemberDto>
	public List<MemberDto> findByNameOrderByHakbunDesc(String memberName);
	public List<MemberDto> findAllByOrderByHakbunDesc();
	public List<MemberDto> findByNameAndGrade(String memberName,int grade);
	public List<MemberDto> findByAgeLessThan(int age);//LessThan 미만<
	public List<MemberDto> findByAgeLessThanEqual(int age);//ThanEqul 이하=<
	public List<MemberDto> findByAgeGreaterThan(int age);//GreaterThan 초과>
	public List<MemberDto> findByAgeGreaterThanEqual(int age);//GreaterThanEqul 이상 >=
	public List<MemberDto> findByAgeBetween(int startAge, int endAge); // 차례대로 int startAge, int endAge 사이에 있는 숫자를 뽑아준다. =< x =<
	public List<MemberDto> findByNameStartingWith(String namekey); // 특정문자로 시작
	public List<MemberDto> findByNameEndingWith(String namekey); // 특정문자로 끝
	public List<MemberDto> findByNameContaining(String namekey); // 특정문자 포함
	
	
}
