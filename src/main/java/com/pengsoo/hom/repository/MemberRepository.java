package com.pengsoo.hom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pengsoo.hom.dto.MemberDto;

public interface MemberRepository extends JpaRepository<MemberDto, Long>{ // 엔티티의 클래스 타입, 기본키 타입>

}
