package com.korea.db;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DeptDAO;
import vo.DeptVO;

@Controller
public class DeptController {
	
	public static final String VIEW_PATH  = "/WEB-INF/views/dept/";
	
	DeptDAO dept_dao;
	public DeptController(DeptDAO dept_dao) {
		this.dept_dao = dept_dao;
		System.out.println("DEPT컨트롤러 생성자 : " + dept_dao);
	}
	
	//전체조회
	@RequestMapping(value = {"/","/list.do"})
	public String list(Model model) {
	
	//dept_dao로 부터 전체목록을 가져온다
	List<DeptVO> list = dept_dao.selectList(); 
	
	//바인딩
	model.addAttribute("list",list);
	
	//포워딩
	return VIEW_PATH + "dept_list.jsp";
	
	//sendRedirect("list.do");
	//return "redirect: list.do";
	
}
	}	
