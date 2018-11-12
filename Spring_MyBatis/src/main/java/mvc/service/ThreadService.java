package mvc.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.dao.ThreadDAO;
import mvc.model.Post;

import java.util.*;


@Service
public class ThreadService {
	
	@Autowired
	private ThreadDAO dao;
	
	public void setDao(ThreadDAO dao) {
		this.dao = dao;
	}
	
	public int count() {
		return this.dao.count();
	}
	
	
	public int insert(Post post) {
		return this.dao.insert(post);
	}
	
	public List<Thread> select() {
		return this.dao.select();
	}
	
	public List <Post> page (HashMap<String, Integer> map){
		return this.dao.page(map);
	}
	
}
