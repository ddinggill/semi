package controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/*")
public class BoardController extends HttpServlet{
	
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
		
		if(path.equals("main.do")) {
			//mainservlet로 이동
			//resp.sendRedirect("../main/main.do");
		}else if(path.equals("boardview.do")) {
			//index.jsp로 이동
			RequestDispatcher dis = req.getRequestDispatcher("/boardview/index.jsp");
			dis.forward(req, resp);
		}else if(path.equals("notice.do")) {
			//index.jsp로 이동
			RequestDispatcher dis = req.getRequestDispatcher("/boardview/notice.jsp");
			dis.forward(req, resp);
		}
			
		if(next!="") { 
			 RequestDispatcher dis = req.getRequestDispatcher(next);
			 dis.forward(req, resp); 
		}
		
	}//end doProcess()

}
