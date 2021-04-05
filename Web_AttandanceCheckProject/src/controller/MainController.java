package controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentDTO;
import model.myService;

@WebServlet("/main.do")
public class MainController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public static myService service;
	
	@Override
	public void init() throws ServletException {
		super.init();
		service = new myService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doService(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		doService(req, resp);
	}
	
	protected void doService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String root = req.getContextPath();
		String act = req.getParameter("act");
		
		if(act.equals("do")) {
			parsing(req, resp);
		}else if(act.equals("mvindex")) {
			resp.sendRedirect(root+"/index.jsp");
		}else {
			
		}
	}
	
	private void parsing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String input = req.getParameter("input");
		ArrayList<StudentDTO>[] list = service.getlist(input);
		
		for(int i=0; i<4; i++) {
			Collections.sort(list[i]);
		}
		String local = req.getParameter("local");
		if(local == null) local = "all";
		String bannum = req.getParameter("bannum");
		if(bannum == null || bannum.equals("")) bannum = "0";
		System.out.println("controller local : " + local);
		System.out.println("controller bannum : " + bannum);
		
		if(local.equals("all") || local.equals("seoul")) {
			req.setAttribute("seoul", list[0]);
		}
		if(local.equals("all") || local.equals("daejeon")) {
			req.setAttribute("daejeon", list[1]);
		}
		if(local.equals("all") || local.equals("gumi")) {
			req.setAttribute("gumi", list[2]);
		}
		if(local.equals("all") || local.equals("gwangju")) {
			req.setAttribute("gwangju", list[3]);
		}
		
		req.setAttribute("local", local);
		req.setAttribute("bannum", bannum);
		req.getRequestDispatcher("/result.jsp").forward(req, resp);
	}
}
