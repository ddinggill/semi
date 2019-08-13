package controller;

//깃허브 테스트 성길
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


//로그인 처리하는 컨트롤러
@WebServlet("/login/*")
public class LoginController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = req.getRequestURI();
		
		path = path.substring(path.lastIndexOf("/") + 1);
		String next="";
		System.out.println(path);
		
		if(path.equals("loginCheck.do")){
			UserDTO user = new UserDTO();
			user.setUserid(req.getParameter("userid"));
			user.setUserpw(req.getParameter("userpw"));
			
			if(UserDAO.getInstance().loginCheck(user)) {
				//로그인 성공시 req에서 세션을 가져와서 세션영역에 그 유저의 정보 저장
				HttpSession session = req.getSession();
				session.setMaxInactiveInterval(30*60);//로그인유지시간 30분
				user= UserDAO.getInstance().userInfo(user);
				session.setAttribute("loginOk", user);
				resp.sendRedirect("/semi/main/main.do");
			}else {
				RequestDispatcher dis = req.getRequestDispatcher("/mainview/LoginForm.jsp");
				req.setAttribute("loginCheck","fail");
				dis.forward(req, resp);
			}
			
		}else if(path.equals("pwfind.do")) {
			RequestDispatcher dis = req.getRequestDispatcher("/mainview/pwfindForm.jsp");
			dis.forward(req, resp);
		}
			
		if(next!="") { 
			 RequestDispatcher dis = req.getRequestDispatcher(next);
			 dis.forward(req, resp);
		}

	}
}
