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
			//네비바의 마이페이지를 클릭시 
			HttpSession session = req.getSession();
			UserDTO dto = (UserDTO)session.getAttribute("loginOk");
			MypageAction mypage = new MypageAction();
			mypage.execute(req, resp);//유저코드로 본인이 작성한 정보를 가져온다.
			RequestDispatcher dis = req.getRequestDispatcher("/mypageview/mypage.jsp");
			dis.forward(req, resp);
			
		}else if(path.equals("memberinfo.do")) {
			//마이페이지에서  회원정보 변경을 클릭 할 시 회원정보 폼으로 이동
			RequestDispatcher dis = req.getRequestDispatcher("/mypageview/memberinfo.jsp");
			dis.forward(req, resp);
			
		}else if(path.equals("memberupdate.do")){
			//회원정보페이지에서 수정할 값을 입력 후 수정버튼 클릭 시 			
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
			
			dao.mypageInfoUpdate(usercode, dto); //유저가 수정할 정보를 가지고 유저 정보를 업데이트 시킨다.
			resp.sendRedirect("/semi/logout");
			
		}
		
		if(next!="") { 
			 RequestDispatcher dis = req.getRequestDispatcher(next);
			 dis.forward(req, resp);
			 //
		}
		
	}//end doprocess()//////////////////////////////////////////
	
}//end controller///////////////////
