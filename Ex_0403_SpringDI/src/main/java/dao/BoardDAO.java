package dao;

import java.util.List;

public interface BoardDAO {
	int insert(Object ob);
	List<String> selectList();
	int update(Object ob);
	int delete( int idx);
}
