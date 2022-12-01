package com.pengsoo.hom;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pengsoo.hom.dto.MemberDto;
import com.pengsoo.hom.repository.MemberRepository;



@Controller
public class HomeController {
	
	@Autowired
	MemberRepository memberRepository;
	
	@RequestMapping("join")
	public String join() {
		return "join";
	}
	
	@RequestMapping("joinOk")
	public String joinOk(HttpServletRequest request) {
		
		String name =request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));//integer로 형변환
		int grade = Integer.parseInt(request.getParameter("grade"));//integer로 형변환
		String etc =request.getParameter("etc");
		
		MemberDto memberDto = new MemberDto();
		memberDto.setName(name);
		memberDto.setAge(age);
		memberDto.setGrade(grade);
		memberDto.setEtc(etc);
		
		MemberDto mDto = memberRepository.save(memberDto);
		
		System.out.println(mDto.toString());
		
		return "joinOk";
	}
	
	@RequestMapping("search")
	public String search() {
		
	List<MemberDto> memberDtos =	memberRepository.findByName("홍길동");
	
	for(MemberDto memberDto : memberDtos) {
		
		System.out.println(memberDto.toString());
	}
		
		return "serarchResult";
	}
	
	
}





