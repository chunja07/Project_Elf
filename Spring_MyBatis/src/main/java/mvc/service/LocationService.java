package mvc.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.dao.*;
import mvc.model.*;

import java.util.*;


@Service
public class LocationService {
	
	@Autowired
	private LocationDAO dao;
	
	public void setDao(LocationDAO dao) {
		this.dao = dao;
	}
	
	public int location(HashMap<String, String> map){
		return this.dao.location(map);
	}
	
	public List<Location> select(){
		return this.dao.select();
	}
	
	/*
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
	*/
}
