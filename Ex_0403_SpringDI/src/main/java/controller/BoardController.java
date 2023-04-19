package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.BoardServiceImp;

//@ : 어노테이션(프로그래밍 주석)
// -> 어노테이션은 @Override처럼 컴파일러에게 오버라이딩 메서드임을 빠르게 캐치하게 하는 용도
// -> @Controller처럼 어노테이션을 통해 특수한 기능을 사용할 수 있도록 동작하게 하는 용도
	
@Controller//컨트롤러에 반드시 필요한 어노테이션
public class BoardController {
	BoardServiceImp service;
	
	public BoardController(BoardServiceImp service ) {
		System.out.println("---나는 컨트롤러의 생성자---");
		this.service = service;
	}
	
	public void setService(BoardServiceImp service) {
		//setter injection을 통해 service객체를 Controller로 불러온다
		this.service = service;
	}
	@RequestMapping(value = {"/","/list.do"})
	public String list(Model model) {
		//list.do가 호출됐을 때 실행되는 메서드
	List<String> list =	service.selectList();
	//list를 model객체에 저장(바인딩)
	model.addAttribute("list",list);
	
	return "board_list"; //포워딩
	}
	
}
