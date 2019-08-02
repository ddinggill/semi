package controller.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserDTO;
import model.mypage.MypageAction;
import model.mypage.MypageDAO;
import model.mypage.MypageUpdateDTO;
@WebServlet("/mypage/*")
public class MypageController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = req.getRequestURI();
		
		path = path.substring(path.lastIndexOf("/")+1);
		String next = "";
		
		System.out.println(path);
		
		if(path.equals("mypage.do")||path.equals("*")) {
			/*
			 * req.getAttribute("loginOK"); System.out.println(req.getAttribute("loginOK"));
			 */
			HttpSession session = req.getSession();
			UserDTO dto = (UserDTO)session.getAttribute("loginOk");
			System.out.println(dto.getName());
			MypageAction mypage = new MypageAction();
			mypage.execute(req, resp);
			RequestDispatcher dis = req.getRequestDispatcher("/mypageview/mypage.jsp");
			dis.forward(req, resp);
			/*
			 * MypageDAO dao = MypageDAO.getInstance(); dao.memberInfo();
			 */
			
		}else if(path.equals("memberinfo.do")) {
			RequestDispatcher dis = req.getRequestDispatcher("/mypageview/memberinfo.jsp");
			dis.forward(req, resp);
			
		}else if(path.equals("memberupdate.do")){
			req.setCharacterEncoding("utf-8");

			
			HttpSession session = req.getSession();
			int usercode;
			MypageUpdateDTO dto = new MypageUpdateDTO();
			UserDTO userdto = (UserDTO)session.getAttribute("loginOk");
			usercode = userdto.getUsercode();
			MypageDAO dao =MypageDAO.getInstance();
			dto.setName(req.getParameter("name"));
			dto.setPassword(req.getParameter("password"));
			dto.setNickname(req.getParameter("nickname"));
			dto.setEmail(req.getParameter("email"));
			
			dao.mypageInfoUpdate(usercode, dto);
			resp.sendRedirect("/semi/logout");
			//resp.sendRedirect("mypage.do");
			
		}
		
		
		
		
		if(next!="") { 
			 RequestDispatcher dis = req.getRequestDispatcher(next);
			 dis.forward(req, resp);
			 //
		}
		
		
		
		
		
		
	}//end doprocess()//////////////////////////////////////////
	
	
	
	
	
}//end controller///////////////////
