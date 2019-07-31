package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserDAO;
import model.UserDTO;

@WebServlet("/login/*")
public class LoginController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = req.getRequestURI();
		
		path = path.substring(path.lastIndexOf("/") + 1);
		String next="";
		System.out.println(path);
		
		
		if(path.equals("lecture.do")) {
			RequestDispatcher dis = req.getRequestDispatcher("/mainview/lecture.jsp");
			dis.forward(req, resp);
		}else if(path.equals("loginCheck.do")){
			UserDTO user = new UserDTO();
			user.setUserid(req.getParameter("userid"));
			user.setUserpw(req.getParameter("userpw"));
			
			if(UserDAO.getInstance().loginCheck(user)) {
				HttpSession session = req.getSession();
				//Cookie cookie = new Cookie("userCookie", req.getParameter("userid"));
				session.setMaxInactiveInterval(300);//5분
				user= UserDAO.getInstance().userInfo(user);
				session.setAttribute("loginOk", user);
				resp.sendRedirect("/semi/main/main.do");
			}else {
				RequestDispatcher dis = req.getRequestDispatcher("/mainview/LoginForm.jsp");
				req.setAttribute("loginCheck","fail");
				dis.forward(req, resp);
			}
			
		}else if(path.equals("logout.do")) {
			
			RequestDispatcher dis = req.getRequestDispatcher("/mainview/lecture.jsp");
			dis.forward(req, resp);
		}else if(path.equals("pwfind.do")) {
			RequestDispatcher dis = req.getRequestDispatcher("/mainview/pwfindForm.jsp");
			dis.forward(req, resp);
		}
			
		if(next!="") { 
			 RequestDispatcher dis = req.getRequestDispatcher(next);
			 dis.forward(req, resp);
			 //
		}

	}
}
