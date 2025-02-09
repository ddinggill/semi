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

//회원가입 및 비밀번호찾기 담당 컨트롤러(joinForm.jsp,pwfinForm.jsp)
@WebServlet("/help/*")
public class joinController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getRequestURI();

		path = path.substring(path.lastIndexOf("/") + 1);
		String next = "";

		// 회원가입요청
		if (path.equals("join.do")) {
			joinAction joinaction = new joinAction();
			joinaction.execute(req, resp);
			RequestDispatcher dis = req.getRequestDispatcher("/mainview/joinForm.jsp");
			dis.forward(req, resp);
		}
		// 패스워드찾기
		else if (path.equals("pwfind.do")) {
			joinDAO dao = joinDAO.getInstance();	
			
			//아이디랑 이메일 있을때
			if(dao.find(req.getParameter("userid"), req.getParameter("useremail"))) {
				//비밀번호 초기화시작
				String newpassword = dao.resetPW(req.getParameter("userid"));
				req.setAttribute("find", 2);
				req.setAttribute("newPW", newpassword); //새로운 패스워드 출력용
			} else {
				//아이디나 이메일을 잘못입력하였을때
				System.out.println("입력 잘못햇습니다.");
				req.setAttribute("find", 3);
			}
			RequestDispatcher dis = req.getRequestDispatcher("/mainview/pwfindForm.jsp");
			dis.forward(req, resp);
		} 
		//아이디 중복체크
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
			
		}
		
	}//end post()
}
