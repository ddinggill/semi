package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserDAO;
import model.UserDTO;
import model.mypage.MypageAction;

@WebServlet("/admin/*")
public class AdminController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = req.getRequestURI();

		path = path.substring(path.lastIndexOf("/") + 1);
		String next = "";

		System.out.println(path);

		if (path.equals("membermanage.do")) {
			UserDAO dao = UserDAO.getInstance();
			List<UserDTO> alist = dao.userAllInfo();
			
			req.setAttribute("userlist", alist);
			
			RequestDispatcher dis = req.getRequestDispatcher("/mainview/adminPage.jsp");
			dis.forward(req, resp);
		}
		
		if(next!="") { 
			 RequestDispatcher dis = req.getRequestDispatcher(next);
			 dis.forward(req, resp);
			 //
		}
		
	}//doprocess()
}
