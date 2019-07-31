package model.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MainAction {
	
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("액션 접속");
		MainDAO dao = MainDAO.getInstance();
		//NoticeDTO Ndto = new NoticeDTO();
		//ReviewDTO Rdto = new ReviewDTO();
		List<NoticeDTO> noticeList = dao.lastNoticeBoard();
		List<ReviewDTO> reviewList = dao.lastReviewBoard();
		
		req.setAttribute("noticeList", noticeList);
		req.setAttribute("reviewList", reviewList);
		
		
		
		
		
	}//end execute/////////////////////////////////////
	
	
}//end class////////////////////////////////////////////
