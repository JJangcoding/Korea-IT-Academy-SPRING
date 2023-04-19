package service;

import java.util.List;

import dao.BoardDAOImp;

public class BoardServiceImp implements BoardService {
	
	BoardDAOImp dao;
	
	public BoardServiceImp( BoardDAOImp dao) {
		// 나중에 ServiceImp가 생성 될 때 DAO객체를 생성자로 받을 예정
		this.dao = dao;
	}
	
	@Override
	public List<String> selectList() {
		// TODO Auto-generated method stub
		return dao.selectList();
	}

}
