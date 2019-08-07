package controller.main;
//깃허브 테스트
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.main.MainAction;

@WebServlet("/main/*")
public class MainController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		doProcess(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}

	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = req.getRequestURI();
		
		path = path.substring(path.lastIndexOf("/") + 1);
		String next="";
		System.out.println(path);
		
		if(path.equals("main.do") || path.equals("*")) {
			//main.jsp로 이동
			MainAction main = new MainAction();
			main.execute(req, resp);
			RequestDispatcher dis = req.getRequestDispatcher("/mainview/main.jsp");
			dis.forward(req, resp);
		}else if(path.equals("lecture.do")) {
			RequestDispatcher dis = req.getRequestDispatcher("/mainview/lecture.jsp");
			dis.forward(req, resp);
		}else if(path.equals("login.do")){
			RequestDispatcher dis = req.getRequestDispatcher("/mainview/LoginForm.jsp");
			dis.forward(req, resp);
		}else if(path.equals("join.do")) {
			RequestDispatcher dis = req.getRequestDispatcher("/mainview/joinForm.jsp");
			dis.forward(req, resp);
		}else if(path.equals("pwfind.do")) {
			RequestDispatcher dis = req.getRequestDispatcher("/mainview/pwfindForm.jsp");
			dis.forward(req, resp);
		}else if(path.equals("mypage.do")) {
			RequestDispatcher dis = req.getRequestDispatcher("/mainview/mypage.jsp");
			dis.forward(req, resp);
		}
			
		if(next!="") { 
			 RequestDispatcher dis = req.getRequestDispatcher(next);
			 dis.forward(req, resp);
			 //
		}
		
	}//end doProcess()
	
}//end class
