package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.DeptVO;

public class DeptDAO {
	
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	//전체목록 조회
	public List<DeptVO> selectList(){
		
		List<DeptVO> list = sqlSession.selectList("d.dept_list");
		return list;
	}
	
}
