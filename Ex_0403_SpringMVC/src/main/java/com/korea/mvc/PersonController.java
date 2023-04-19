package com.korea.mvc;

import java.util.List;

import javax.lang.model.element.ModuleElement;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.PersonDAO;
import vo.PersonVO;

@Controller
public class PersonController {
	
	public static final String VIEW_PATH = "/WEB-INF/views/person/";
	
	PersonDAO person_dao;
	
	public PersonController(PersonDAO person_dao) {
		System.out.println("--- PersonController() 생성자 ---");
		this.person_dao=person_dao;
	}
	//전체목록 조회
	@RequestMapping(value = {"/", "/list.do"})
	public String select(Model model,HttpServletRequest request) {
		//dao로부터 검색결과 가져오기
		List<PersonVO> list = person_dao.selectList();
		
		//ip 가져오기
		String ip = request.getRemoteAddr();
		
		//바인딩
		model.addAttribute("list",list);
		model.addAttribute("ip", ip);
		
		//포워딩
		return VIEW_PATH + "person.jsp";
	}

}
