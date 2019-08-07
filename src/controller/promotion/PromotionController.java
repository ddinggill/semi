package controller.promotion;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.UserDTO;
import model.promotion.CommentViewAction;
import model.promotion.CommentWriteAction;
import model.promotion.ListAction;
import model.promotion.PromotionDAO;
import model.promotion.PromotionDTO;
import model.promotion.PromotionDeleteAction;
import model.promotion.PromotionDeleteTwoAction;
import model.promotion.PromotionFileDownloadAction;
import model.promotion.UpdateFormAction;
import model.promotion.UpdateProAction;
import model.promotion.ViewAction;
import model.promotion.WriteAction;
@WebServlet("/promotion/*")
public class PromotionController extends HttpServlet{
	
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
		String next="";
		System.out.println(path);
		
		
		if(path.equals("promotion.do")) { //네비바에서 홍보문의 클릭시
			//홍보문의 클릭시 일반사용자와 관리자별로 다른 페이지를 보여줌
			
			HttpSession session = req.getSession();
			int userlevel ;
			UserDTO dto = (UserDTO) session.getAttribute("loginOk");
			userlevel = dto.getUserlevel();
			
			if(userlevel == 1) {
				RequestDispatcher dis = req.getRequestDispatcher("/promotionview/write.jsp");
				dis.forward(req, resp);
			}else if(userlevel == 0) {
				RequestDispatcher dis = req.getRequestDispatcher("/promotion/board.do");
				dis.forward(req, resp);
			}
		}else if(path.equals("insert.do")) {
			//일반사용자가 홍보문의를 클릭시	
			WriteAction write = new WriteAction();
			write.execute(req, resp);
			RequestDispatcher dis = req.getRequestDispatcher("/main/main.do");
			dis.forward(req, resp);
			
			
		}else if(path.equals("board.do")) {
			//관리자가 홍보문의를 클릭시
			System.out.println("board접근");
			ListAction list = new ListAction();
			///////////////////////////////답변글 로딩
			list.execute(req, resp);
			next = "/promotionview/board.jsp";
			
		}else if(path.equals("view.do")) {
			//홍보문의 게시판의 게시물을 클릭시(마이페이지에서 , 관리자의 홍보문의게시판에서)
			System.out.println("뷰 접근");
			ViewAction view = new ViewAction();
			view.execute(req, resp);
			next = "/promotionview/view.jsp";
			
		}else if(path.equals("updateForm.do")) {
			UpdateFormAction update = new UpdateFormAction();
			
			update.execute(req, resp);
			next = "/promotionview/update.jsp";
		}else if(path.equals("updatepro.do")) {
			UpdateProAction updatepro = new UpdateProAction();
			MultipartRequest multi = updatepro.executeMulti(req);
			String boardkey = multi.getParameter("boardkey");
			resp.sendRedirect("view.do?boardkey="+ boardkey);	
			
		}else if (path.equals("promotionwrite.do")) {
			////////////////////////////////답변글 write
			req.setCharacterEncoding("utf-8");
			RequestDispatcher dis = req.getRequestDispatcher("/promotionview/commentwrite.jsp");
			dis.forward(req, resp);
			
			//답변글 가기//
			
		}else if (path.equals("commentinsert.do")) {
			//write에서 가져온 값 insert후 목록으로 돌아가기
			req.setCharacterEncoding("utf-8");
			CommentWriteAction write = new CommentWriteAction();
			write.execute(req, resp);
			System.out.println("답변글 insert 접근");
			RequestDispatcher dis = req.getRequestDispatcher("/promotion/promotion.do");
			dis.forward(req, resp);
			
			
		}else if(path.equals("commentview.do")) {
			req.setCharacterEncoding("utf-8");
			CommentViewAction view = new CommentViewAction();
			view.execute(req, resp);
			System.out.println("답변글 뷰 접근");
			next = "/promotionview/commentview.jsp";
			
			
			
		}else if(path.equals("delete.do")) {
			//문의글과 그에 달린 답변글 제거
			System.out.println("문의제거");
			PromotionDeleteAction delete = new PromotionDeleteAction();
			delete.execute(req, resp);
			
			HttpSession session = req.getSession();
			int userlevel ;
			UserDTO dto = (UserDTO) session.getAttribute("loginOk");
			userlevel = dto.getUserlevel();
			if(userlevel == 1) {
			RequestDispatcher dis = req.getRequestDispatcher("/mypage/mypage.do");
			dis.forward(req, resp);
			//resp.sendRedirect("/mypage/mypage.do");
			}else if(userlevel ==0) {
				RequestDispatcher dis = req.getRequestDispatcher("/promotion/board.do");
				dis.forward(req, resp);
			}
		}else if (path.equals("download.do")) {
			PromotionFileDownloadAction down = new PromotionFileDownloadAction();
			down.execute(req, resp);
			//next = "/promotionview/view.jsp";
			
			
		}else if(path.equals("delete_promotion.do")) {
			System.out.println("답글삭제 컨트롤러 접근");
			PromotionDeleteTwoAction delete = new PromotionDeleteTwoAction();
			delete.execute(req, resp);
			
			RequestDispatcher dis = req.getRequestDispatcher("/promotion/board.do");
			dis.forward(req, resp);
			
		}
		
		
		
		
		if(next!="") { 
			 RequestDispatcher dis = req.getRequestDispatcher(next);
			 dis.forward(req, resp);
			 //
		}
		
		
		
	}//doprocess()////////////////////////////
	
	

}//end class
