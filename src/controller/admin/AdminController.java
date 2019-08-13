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
import model.admin.AdminDAO;
import model.admin.PageDTO;
import model.join.joinDAO;
import model.mypage.MypageAction;

//관리자 모드에서 회원정보 수정 및 삭제담당하는 컨트롤러(adminPage.jsp에서 요청)
@WebServlet("/admin/*")
public class AdminController extends HttpServlet{
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

		path = path.substring(path.lastIndexOf("/") + 1);
		String next = "";

		System.out.println(path);
		
		//회원목록요청 작업처리
		if (path.equals("membermanage.do")) {
			AdminDAO dao = AdminDAO.getInstance();
			String pageNum = req.getParameter("pageNum");
			if(pageNum==null)
				pageNum="1";
			
			int currentPage = Integer.parseInt(pageNum);
			int totalCount = dao.rowCount();
			
			PageDTO pdto = new PageDTO(currentPage,totalCount);
			
			List<UserDTO> alist = dao.userAllInfo(pdto);
			req.setAttribute("userlist", alist);
			req.setAttribute("pdto", pdto);
			
			RequestDispatcher dis = req.getRequestDispatcher("/mainview/adminPage.jsp");
			dis.forward(req, resp);
			
		}else if(path.equals("update.do")) {//회원유저레벨 변견요청 작업처리
			System.out.println("유저레벨 변경요청");
			String usercode = req.getParameter("usercode");
			String userlevel = req.getParameter("userlevel");
			AdminDAO dao = AdminDAO.getInstance();
			dao.userlevelUpdate(Integer.parseInt(usercode), Integer.parseInt(userlevel));
			resp.setContentType("text/html;charset=UTF-8");
			resp.getWriter().append(userlevel);
			
		}else if(path.equals("delete.do")) {//회원삭제요청 작업처리
			String usercode=req.getParameter("usercode");
			String pageNum = req.getParameter("pageNum");
			AdminDAO dao=AdminDAO.getInstance();
			dao.userdelete(Integer.parseInt(usercode));	
			
			int currentPage = Integer.parseInt(pageNum);
			int cnt = dao.rowCount();
			
			resp.setContentType("text/html;charset=UTF-8");
			//삭제시 페이지가 줄어들경우 처리
			if(cnt>0) {
				PageDTO pdto = new PageDTO(currentPage, cnt);
				if(pdto.getEndPage()<currentPage) {
					resp.getWriter().print(currentPage-1);
				}else {
					resp.getWriter().print(currentPage);
				}
			}
		}
		
		if(next!="") { 
			 RequestDispatcher dis = req.getRequestDispatcher(next);
			 dis.forward(req, resp);
			 //
		}
		
	}//doprocess()
}
