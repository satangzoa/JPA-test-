package com.pengsoo.hom;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.pengsoo.hom.dto.MemberDto;
import com.pengsoo.hom.repository.MemberRepository;



@SpringBootTest
@TestPropertySource(locations ="classpath:application-test.properties")
public class JpaTest {

	@Autowired
	MemberRepository memberRepository;
	
	@Test
	@DisplayName("이름 검색 테스트")
	public void searchName() {
		
		List<MemberDto> dtos = memberRepository.findByNameContaining("길");//List java.util로 import
		
		for(MemberDto memberDto : dtos) {
			System.out.println(memberDto.toString());
		};
	}
	
}
