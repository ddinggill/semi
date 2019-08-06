package controller.join;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.join.joinAction;
import model.join.joinDAO;

@WebServlet("/help/*")
public class joinController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String path = req.getRequestURI();

		path = path.substring(path.lastIndexOf("/") + 1);
		String next = "";

		if (path.equals("join.do")) {
			System.out.println("회원가입요청도착");
			joinAction joinaction = new joinAction();
			joinaction.execute(req, resp);
			RequestDispatcher dis = req.getRequestDispatcher("/mainview/joinForm.jsp");
			dis.forward(req, resp);
		} // 회원가입요청

		else if (path.equals("pwfind.do")) {
			joinDAO dao = joinDAO.getInstance();	
			
			//아이디랑 이메일 있을때
			if(dao.find(req.getParameter("userid"), req.getParameter("useremail"))) {
				//비밀번호 초기화시작
				String newpassword = dao.resetPW(req.getParameter("userid"));
				req.setAttribute("find", 2);
				req.setAttribute("newPW", newpassword); //새로운 패스워드 출력용
			} else {
				System.out.println("입력 잘못햇습니다.");
				req.setAttribute("find", 3);
			}
			RequestDispatcher dis = req.getRequestDispatcher("/mainview/pwfindForm.jsp");
			dis.forward(req, resp);
		} // 패스워드찾기
		
		else if (path.equals("idchk.do")) {
			System.out.println("아이디중복체크 작업요청");
			String userid = req.getParameter("userid");
			System.out.println(userid);
			joinDAO dao = joinDAO.getInstance();
			resp.setContentType("text/html;charset=UTF-8");
			if(dao.idchk(userid)) {
				resp.getWriter().append("true");
			}
			else {
				resp.getWriter().append("false");
			}
			
		}//아이디 중복체크
		
	}//end post()
}
