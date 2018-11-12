package mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import javax.imageio.stream.FileCacheImageInputStream;
import javax.servlet.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import mvc.service.LocationService;
import mvc.service.MemberService;
import mvc.service.ThreadService;
import mvc.dao.LocationDAO;
import mvc.model.*;


@SessionAttributes("islogin")
@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	@Autowired
	private ThreadService threadService;
	@Autowired
	private LocationService locationService;
	
	
	public void setService(MemberService service) {
		this.service = service;
	}
	
	public void setThreadService(ThreadService threadService) {
		this.threadService = threadService;
	}
	
	@RequestMapping("/count")
		public String count(Model model) {
		model.addAttribute("count", service.getRecordCount());
		return "member/count";
	}
	
	@RequestMapping("login")
	public String login() {
		return "member/loginPage";
	}
		
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, HttpServletRequest request , HttpServletResponse response) {
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setPassword(request.getParameter("password"));
		
		model.addAttribute("login", service.login(member));
		
		System.out.println("Service.login = " + service.login(member));
		System.out.println("Service.login.get(password) = " + service.login(member).getPassword());
		
		
		if(member==null || !service.login(member).getPassword().equals(member.getPassword())){
			request.setAttribute("result", 0);
		} else {
			request.setAttribute("result", 1);
			model.addAttribute("islogin", service.login(member));
		}
						
		return "member/loginResult";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, SessionStatus status, HttpSession session) {
		
		status.setComplete();
				
		return "redirect:/";
	}
	
	@RequestMapping(value = "/thread", method = RequestMethod.GET)
	public String thread(Model model, HttpServletRequest request) {
		
		int page = 1;
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int count = 3;
				
		HashMap<String, Integer> map = new HashMap<>();
		map.put("start", (page-1)*count);
		map.put("end", count);
		
		Post post = new Post();
		
		model.addAttribute("count", threadService.count());						
		model.addAttribute("post", threadService.page(map));
		
		int recordCount = threadService.count();
		int totalPage = recordCount / count + (recordCount % count != 0 ? 1 : 0);
		int pageCount = 4;
		
		int startPage = (page-1) / pageCount * pageCount;
		if(startPage % pageCount == 0)
			startPage += 1;
		int endPage = startPage + pageCount - 1;
		if(endPage > totalPage)
			endPage = totalPage;
		
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", page);
		
		
		
		return "thread/thread";
	}
	
	@RequestMapping("/map")
	public String map(Model model) {
							
		return "map/map";
	}
	
	@RequestMapping(value = "/location", method = RequestMethod.GET)
	public String location(Model model) {
		
		model.addAttribute("lol", locationService.select());	
		
		return "location/location";
	}
	
	@RequestMapping(value = "/location", method = RequestMethod.POST)
	public String locationInsert(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		// File
			
		BufferedReader bin = null;
		FileReader freader = null;
		
		HashMap<String, String> map = new HashMap<>();
		String path = "C:\\dev\\java_ee\\source\\Spring_MyBatis\\src\\main\\resources\\National_DB_final.csv";
		
		bin = new BufferedReader(new InputStreamReader(new FileInputStream(path),"euc-kr"));
		StringTokenizer st = null;
		String b = null;
		
		while((b = bin.readLine()) != null) {
			System.out.println(b);
			
			st = new StringTokenizer(b, ",");
			String str[] = new String [2];
			
			for(int i = 0; st.hasMoreTokens(); i++) {
				str[i] = st.nextToken();
			}
			
			map.put("province", str[0]);
			map.put("district", str[1]);
			
			System.out.println("str[0] =" + str[0]);
			System.out.println("str[1] =" + str[1]);
			
			model.addAttribute("location", locationService.location(map));
			
			
		}
				
		bin.close();
		
		System.out.println("db 인서트 완료");
		
		return "location/locationResult";
	}
	
	
	
}
