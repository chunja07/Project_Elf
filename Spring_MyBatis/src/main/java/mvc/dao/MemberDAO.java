package mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mvc.model.Member;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String strSqlSession = "mvc.model.MemberMapper";
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int getRecordCount() {
		return sqlSession.selectOne(strSqlSession + ".count");
	}
	
	public Member login(Member member) {
		return sqlSession.selectOne(strSqlSession + ".login", member);
	}
	
}
