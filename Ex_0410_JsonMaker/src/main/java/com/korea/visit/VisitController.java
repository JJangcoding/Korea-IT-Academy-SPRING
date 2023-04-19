package com.korea.visit;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.VisitDAO;
import util.MyCommon;
import vo.VisitVO;

@Controller
public class VisitController {
	
	@Autowired //자동주입 : spring으로부터 자동생성 가능한 객체를 new없이 알아서 생성해 준다
	HttpServletRequest request;
	
	@Autowired
	ServletContext app;
	
	VisitDAO visit_dao;
	public void setVisit_dao(VisitDAO visit_dao) {
		this.visit_dao = visit_dao;
	}
	
	//방명록 전체정보 조회
	@RequestMapping( "/list2.do" )
	public String list( Model model) {
		List<VisitVO> list = visit_dao.selectList();
		model.addAttribute("list", list);//바인딩
		return MyCommon.Visit.VIEW_PATH + "visit_list.jsp";//포워딩
	}
	
	//새 글 추가 폼으로 화면전환
	@RequestMapping("/insert_form2.do")
	public String insert_form() {
		return MyCommon.Visit.VIEW_PATH + "visit_insert_form.jsp";
	}
	
	//새 글 추가
	@RequestMapping("/insert2.do")
	public String insert( VisitVO vo ) {
		//insert.do?name=홍길동&content=내용&pwd=1111
		//vo파라미터를 통해 이름, 내용, 비밀번호는 이미 받아온 상태
		
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		
		//이미지가 저장 될 절대경로
		String webPath = "/resources/upload/";
		String savePath = app.getRealPath(webPath);
		System.out.println("절대경로 : " + savePath);
		
		//업로드 된 파일 정보
		MultipartFile photo = vo.getPhoto();
		
		String filename = "no_file";
		if( !photo.isEmpty() ) {
			//DB에 추가할 실제 파일의 이름
			filename = photo.getOriginalFilename();
			
			//파일을 저장할 절대경로
			File saveFile = new File(savePath, filename);
			
			if( !saveFile.exists() ) {
				saveFile.mkdirs();//절대경로에 upload라는 이름의 폴더를 생성한다
			}else {
				//동일파일일 경우 현재 업로드 시간을 붙여서 이름변경
				long time = System.currentTimeMillis();
				filename = String.format("%d_%s", time, filename);
				saveFile = new File(savePath, filename);
			}
			
			try {
				//업로드를 요청한 파일은 MultipartResolver클래스가 임시저장소에 보관한다
				//임시 저장소에 보관된 파일은 일정 시간이 지나면 사라지므로, 절대경로 위치에
				//이미지를 물리적으로 복사해 넣어야 한다
				photo.transferTo(saveFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		vo.setFilename(filename);
		visit_dao.insert( vo );
		
		//sendRedirect("list.do")
		return "redirect:list.do";//url매핑을 호출
	}
	
	//글 삭제
	@RequestMapping("/delete2.do")
	@ResponseBody //Ajax로 요청된 메서드가 반드시 가지고 있어야 하는 어노테이션
	public String delete( int idx ) {
		
		//delete.do?idx=2
		
		int res = visit_dao.delete(idx);
		
		String result = "no";
		if( res != 0 ) {
			result = "yes";
		}
		
		//@ResponseBody의 속성을 통해 반환된 result값이 
		//자동으로 콜백메서드로 전달
		return result;
		
	}
	
	//글 수정 폼으로 이동
	@RequestMapping("/modify_form2.do")
	public String modify_form( Model model, int idx ) {
		
		//파라미터로 넘겨받은 idx에 해당하는 게시글 한 건 조회
		VisitVO vo = visit_dao.selectOne( idx );
		
		model.addAttribute("vo", vo);
		return MyCommon.Visit.VIEW_PATH + "visit_modify_form.jsp";
	}
	
	//글 수정
	@RequestMapping( value="/modify2.do", produces="application/json;charset=UTF-8" )
	@ResponseBody //ResponsBody가 있어야 return값을 콜백메서드로 돌려줄 수 있다.
	public String modify( VisitVO vo ) {
		//modify.do?idx=3&name=홍길동&content=내용&pwd=1111
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		
		int res = visit_dao.update(vo);
		String result = "수정 성공";
		
		if( res == 0 ) {
			result = "수정 실패";
		}
		
		//값을 가지고 콜백메서드로 돌아간다
		//return된 데이터에 한글이 포함되어 있다면 깨져서 넘어간다.
		//이를 해결하기 위해 @RequestMapping 영역에 코드를 추가해줘야 한다
		return result;
	}
}


















