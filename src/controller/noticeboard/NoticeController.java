package controller.noticeboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import model.noticeboard.DeleteAction;
import model.noticeboard.FileDownLoadAction;
import model.noticeboard.ListAction;
import model.noticeboard.UpdateFormAction;
import model.noticeboard.UpdateProAction;
import model.noticeboard.ViewAction;
import model.noticeboard.WriteAction;


//공지사항 게시판 처리 컨트롤러
@WebServlet("/notice/*")
public class NoticeController extends HttpServlet{
	
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
		
		//목록작업 요청
		if(path.equals("list.do")) {
			ListAction list = new ListAction();
			list.execute(req, resp);
			next = "/noticeview/notice.jsp";
		}
		//글쓰기 페이지로 이동
		else if(path.equals("writeform.do")) {
			next = "/noticeview/write.jsp";
		}
		//글쓰기 작업 요청
		else if(path.equals("write.do")) {
			WriteAction write = new WriteAction();
			write.execute(req, resp);
			resp.sendRedirect("list.do");
		}
		//글보기 
		else if(path.equals("view.do")) {
			ViewAction view = new ViewAction();
			view.execute(req, resp);
			next = "/noticeview/view.jsp";
		}
		//첨부파일 다운로드
		else if(path.equals("download.do")) {
			FileDownLoadAction download = new FileDownLoadAction();
			download.execute(req, resp);
		}
		//수정페이지로
		else if(path.equals("updateForm.do")) {
			UpdateFormAction update = new UpdateFormAction();
			update.execute(req, resp);
			next = "/noticeview/update.jsp";
		}
		//수정작업처리
		else if(path.equals("updatePro.do")) {
			UpdateProAction updatepro = new UpdateProAction();
			MultipartRequest multi = updatepro.executeMulti(req);
			String param="pageNum="+multi.getParameter("pageNum");
			resp.sendRedirect("list.do?"+param);
		}
		//글삭제
		else if(path.equals("delete.do")) {
			DeleteAction delete = new DeleteAction();
			delete.execute(req, resp);
			String param="pageNum="+req.getAttribute("pageNum");
			resp.sendRedirect("list.do?"+param);
		}
			
		if(next!="") { 
			 RequestDispatcher dis = req.getRequestDispatcher(next);
			 dis.forward(req, resp); 
		}
		
	}//end doProcess()

}
