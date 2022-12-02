package com.pengsoo.hom;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
	public String joinOk(HttpServletRequest request, Model model) {
		
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
		
		model.addAttribute("mDto", mDto);
		
		return "joinOk";
	}
	
	@RequestMapping("search")
	public String search() {
	return "search";
	
	}
	
	@RequestMapping("searchOk")
	public String search(Model model,HttpServletRequest request) {
		
	//List<MemberDto> memberDtos = memberRepository.findByName(request.getParameter("searchName"));
	
	List<MemberDto> memberDtos = memberRepository.findByNameOrderByHakbunDesc(request.getParameter("searchName"));
	for(MemberDto memberDto : memberDtos) {
		System.out.println(memberDto.toString());
	}
		
	model.addAttribute("searchDtos", memberDtos);
		return "searchResult";
	}
	
	@RequestMapping("allmember")
	public String allmember(Model model) {
		
		List<MemberDto> memberDtos = memberRepository.findAll(Sort.by(Sort.Direction.DESC, "hakbun"));
		
		List<MemberDto> memberDtos2 = memberRepository.findAllByOrderByHakbunDesc();
		
		model.addAttribute("allmember", memberDtos2);
		
		return "allmember";
	}
	
	@RequestMapping("memberOr")
	public String memberOr(){
		List<MemberDto> memberDtos = memberRepository.findByNameAndGrade("홍길동", 3);
		
		for(MemberDto memberDto : memberDtos) {
			System.out.println(memberDto.toString());
		};
		return "";
	}

	@RequestMapping("lessthan")
	public String lessthan() {
		List<MemberDto> memberDtos = memberRepository.findByAgeLessThan(30);
		
		for(MemberDto memberDto : memberDtos) {
			System.out.println(memberDto.toString());
		};
		return "";
	}
	
	@RequestMapping("between")
	public String between() {
		List<MemberDto> memberDtos = memberRepository.findByAgeBetween(10,31);
		
		for(MemberDto memberDto : memberDtos) {
			System.out.println(memberDto.toString());
		};
		return "";
	}
	
	@RequestMapping("like")
	public String like() {
		List<MemberDto> memberDtos = memberRepository.findByNameStartingWith("홍");
		
		for(MemberDto memberDto : memberDtos) {
			System.out.println(memberDto.toString());
		};
		return "";
	}
}








