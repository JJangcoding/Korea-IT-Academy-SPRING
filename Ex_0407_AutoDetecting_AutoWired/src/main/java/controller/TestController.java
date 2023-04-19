package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.TotalService;
import vo.DeptVO;

@Controller
public class TestController {
	
	TotalService service;
	
	@Autowired
	public TestController(TotalService service) {
		this.service = service;
		
		System.out.println("--TestController를 생성했어요--");
		System.out.println( "service : " + service );
	}
	
	//부서조회
	@RequestMapping(value={"/", "/list.do"})
	public String dept_list( Model model ) {
		
		List<DeptVO> dept_list = service.selectList();
		model.addAttribute("list", dept_list);
		return "/WEB-INF/views/dept_list.jsp";
	}
	
}















