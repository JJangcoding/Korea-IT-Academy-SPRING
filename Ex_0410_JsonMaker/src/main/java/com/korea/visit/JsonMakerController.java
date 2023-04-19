package com.korea.visit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vo.PersonVO;

@Controller
public class JsonMakerController {

	@RequestMapping("/vo_to_json.do")
	@ResponseBody
	public PersonVO vo_to_json() {
		PersonVO p = new PersonVO("일길동", 10, "서울시 마포구");
		return p; //p객체를 json구조로 변환하여 반환한다
	}
	
}

















