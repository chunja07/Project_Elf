package mvc.model;

import java.text.SimpleDateFormat;
import java.util.*;

public class Post {
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

	private int no;
	private String id;
	private String name;
	private String title;
	private String content;
	private Date registerdate;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegisterdate() {
		return registerdate.toLocaleString();
	}
	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}
	
	
}
