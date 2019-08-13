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
import model.festival.WriteFestival;

/*
 * 축제와 리뷰에 관한 모든 입력처리와 흐름제어를 관장하는 컨트롤러
 * 작성자 : 박종현
 * 작성일 : 2019.08.13
 */

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
		
		// 모든 축제 리스트를 출력
		if(action.equals("/*") || action.equals("/list.do")) {
			ListAction list = new ListAction();
			list.execute(req, resp);
			path= "/festival/list.jsp";
		
		// 지역과 기간을 선택하여 보길 원하는 축제 리스트를 출력
		}else if(action.equals("/searchList.do")) {
			SearchListAction Search = new SearchListAction();
			Search.execute(req, resp);
			path = "/festival/searchList.jsp";
			
		// 선택된 축제의 상세 내용을 출력
		}else if(action.equals("/view.do")) {
			ViewAction view = new ViewAction();
			view.execute(req, resp);
			path = "/festival/contents.jsp";
		
		// 인기 축제 리스트를 출력
		}else if(action.equals("/hotList.do")) {
			HotListAction hotList = new HotListAction();
			hotList.execute(req, resp);
			path= "/festival/hotList.jsp";
		
		// 축제글을 등록
		}else if (action.equals("/write.do")) {
	        WriteFestival write = new WriteFestival();
	        write.execute(req, resp);
	        resp.sendRedirect("/semi/main/main.do");
	        
	    // 모든 후기 리스트를 출력
	    }else if (action.equals("/reviewList.do")) {
			ReviewBoardListAction reviewList = new ReviewBoardListAction();
			reviewList.execute(req);
			path = "/review/reviewBoardList.jsp";
		
		// 선택된 후기의 상세 내용을 출력
		}else if (action.equals("/reviewView.do")) {
			ReviewBoardViewAction reviewView = new ReviewBoardViewAction();
			reviewView.execute(req);
			path = "/review/reviewBoardView.jsp";
		
		// 후기글 등록폼으로 이동
		} else if (action.equals("/reviewWriteForm.do")) {
			path = "/review/reviewBoardWrite.jsp";
		
		// 후기글을 등록
		} else if (action.equals("/reviewWrite.do")) {
			ReviewBoardWriteAction reviewWrite = new ReviewBoardWriteAction();
			MultipartRequest multi = reviewWrite.executeMulti(req);
			resp.sendRedirect("view.do?fcode="+multi.getParameter("fcode")); 
		
		// 후기글의 첨부파일을 다운로드
		}else if(action.equals("/reviewDownload.do")) {
			FileDownLoadAction download = new FileDownLoadAction();
			download.execute(req, resp);
		
		// 후기글의 내용을 수정하기 위해 기존 정보를 가지고 수정폼으로 이동
		}else if (action.equals("/reviewUpdateForm.do")) {
			ReviewBoardUpdateFormAction reviewUpdate = new ReviewBoardUpdateFormAction();
			reviewUpdate.execute(req , resp);
			path = "/review/reviewUpdate.jsp";
		
		// 후기글의 내용을 수정
		}else if(action.equals("/reviewUpdatePro.do")) {
			ReviewBoardUpdateProAction reviewUpdatePro = new ReviewBoardUpdateProAction();
			MultipartRequest multi = reviewUpdatePro.executeMulti(req);
			String param = "pageNum="+multi.getParameter("pageNum");
				param+="&searchKey="+multi.getParameter("searchKey"); //검색할 속성
				param += "&searchWord=" + multi.getParameter("searchWord"); //검색어
			resp.sendRedirect("reviewList.do?"+param);
		
		// 후기글을 삭제
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
		// 댓글 등록
		}else if(action.equals("/commentAdd.do")) {
			CommentAdd coa = new CommentAdd();
			coa.execute(req, resp);
		}//댓글리스트 출력 
		else if(action.equals("/commentList.do")) {
			CommentList col = new CommentList();
			col.execute(req, resp);
		}//댓글 삭제
		else if(action.equals("/CommentDel.do")) {
			CommentDel cod = new CommentDel();
			cod.execute(req, resp);
		}//댓글 수정 
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
