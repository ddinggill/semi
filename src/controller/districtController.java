package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import model.festival.CommentAdd;
import model.festival.CommentDel;
import model.festival.CommentList;
import model.festival.CommentUpdate;
import model.festival.FileDownLoadAction;
import model.festival.HotListAction;
import model.festival.ListAction;
import model.festival.ReviewBoardDeleteAction;
import model.festival.ReviewBoardListAction;
import model.festival.ReviewBoardUpdateFormAction;
import model.festival.ReviewBoardUpdateProAction;
import model.festival.ReviewBoardViewAction;
import model.festival.ReviewBoardWriteAction;
import model.festival.SearchListAction;
import model.festival.ViewAction;

@WebServlet("/district/*")
public class districtController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		System.out.println("uri: "+uri);
		
		String action = uri.substring(uri.lastIndexOf("/"));
		String path="";
		
		if(action.equals("/*") || action.equals("/list.do")) {
			ListAction list = new ListAction();
			list.execute(req, resp);
			path= "/festival/list.jsp";
			
		}else if(action.equals("/searchList.do")) {
			SearchListAction Search = new SearchListAction();
			Search.execute(req, resp);
			path = "/festival/searchList.jsp";
			
		}else if(action.equals("/view.do")) {
			ViewAction view = new ViewAction();
			view.execute(req, resp);
			path = "/festival/contents.jsp";
			
		}else if(action.equals("/hotList.do")) {
			HotListAction hotList = new HotListAction();
			hotList.execute(req, resp);
			path= "/festival/hotList.jsp";
			
		}else if (action.equals("/reviewList.do")) {
			ReviewBoardListAction reviewList = new ReviewBoardListAction();
			reviewList.execute(req);
			path = "/review/reviewBoardList.jsp";
			
		}else if (action.equals("/reviewView.do")) {
			ReviewBoardViewAction reviewView = new ReviewBoardViewAction();
			reviewView.execute(req);
			path = "/review/reviewBoardView.jsp";
			
		} else if (action.equals("/reviewWriteForm.do")) {
			path = "/review/reviewBoardWrite.jsp";
			
		} else if (action.equals("/reviewWrite.do")) {
			ReviewBoardWriteAction reviewWrite = new ReviewBoardWriteAction();
			MultipartRequest multi = reviewWrite.executeMulti(req);
			resp.sendRedirect("view.do?fcode="+multi.getParameter("fcode")); 
			
		}else if(action.equals("/reviewDownload.do")) {
			FileDownLoadAction download = new FileDownLoadAction();
			download.execute(req, resp);
			
		}else if (action.equals("/reviewUpdateForm.do")) {
			ReviewBoardUpdateFormAction reviewUpdate = new ReviewBoardUpdateFormAction();
			reviewUpdate.execute(req , resp);
			path = "/review/reviewUpdate.jsp";
			
		}else if(action.equals("/reviewUpdatePro.do")) {
			ReviewBoardUpdateProAction reviewUpdatePro = new ReviewBoardUpdateProAction();
			MultipartRequest multi = reviewUpdatePro.executeMulti(req);
			String param = "pageNum="+multi.getParameter("pageNum");
				param+="&searchKey="+multi.getParameter("searchKey");
				param += "&searchWord=" + multi.getParameter("searchWord");
			resp.sendRedirect("reviewList.do?"+param);
			
		}else if(action.equals("/reviewDelete.do")) {
			ReviewBoardDeleteAction reviewDelete = new ReviewBoardDeleteAction();
			reviewDelete.execute(req);
			String pageNum = req.getParameter("pageNum");
			System.out.println(pageNum);
			int page = Integer.parseInt(req.getParameter("number")); 
			String param="&searchKey="+req.getParameter("searchKey");
			param += "&searchWord=" + req.getParameter("searchWord");
			if (page == 1) { 
				resp.sendRedirect("reviewList.do?pageNum=" + (Integer.parseInt(req.getParameter("pageNum"))-1)+param); 
			}else {
				resp.sendRedirect("reviewList.do?pageNum=" + req.getParameter("pageNum")+param); 
			}
		}else if(action.equals("/commentAdd.do")) {
			CommentAdd coa = new CommentAdd();
			coa.execute(req, resp);
		}//댓글리스트 출력 
		else if(action.equals("/commentList.do")) {
			CommentList col = new CommentList();
			col.execute(req, resp);
		}//댓글리스트 출력 
		else if(action.equals("/CommentDel.do")) {
			CommentDel cod = new CommentDel();
			cod.execute(req, resp);
		}//댓글리스트 수정 
		else if(action.equals("/CommentUpdate.do")) {
			CommentUpdate cou = new CommentUpdate();
			cou.execute(req, resp);
		}
		
		
		if(path != "") {
			RequestDispatcher dis = req.getRequestDispatcher(path);
			dis.forward(req, resp);
		}
	}
}
