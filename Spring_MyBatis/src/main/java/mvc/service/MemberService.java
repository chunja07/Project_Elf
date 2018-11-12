package mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.dao.MemberDAO;
import mvc.model.*;
import mvc.dao.*;
import mvc.controller.*;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	
	public int getRecordCount() {
		return this.dao.getRecordCount();
	}
	
	public Member login(Member member) {
		return this.dao.login(member);
	}
	
	
}
