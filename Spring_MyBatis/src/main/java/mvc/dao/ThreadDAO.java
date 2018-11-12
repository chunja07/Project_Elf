package mvc.dao;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mvc.model.Post;

@Repository
public class ThreadDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String strSqlSession = "mvc.model.ThreadMapper";
		
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int count() {
		return sqlSession.selectOne(strSqlSession + ".count");
	}
	
	public int insert(Post post) {
		return sqlSession.insert(strSqlSession + ".insert", post);
	}
	public List <Thread> select() {
		return sqlSession.selectList(strSqlSession + ".select");
	}
	
	public List <Post> page(HashMap<String, Integer> map){
		
		return sqlSession.selectList(strSqlSession + ".page", map);
	}
	
}
