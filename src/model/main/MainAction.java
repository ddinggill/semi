package model.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MainAction {
	
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("액션 접속");
		MainDAO dao = MainDAO.getInstance();
		List<NoticeDTO> noticeList = dao.lastNoticeBoard();//최근 작성된 공지사항을 가져온다.
		List<ReviewDTO> reviewList = dao.lastReviewBoard();//최근 작성된 후기를 가져온다.
		
		req.setAttribute("noticeList", noticeList); //최근의 값을 담아서 jsp파일로 보냄
		req.setAttribute("reviewList", reviewList);//최근의 값을 담아서 jsp파일로 보냄
		
		
		
		
		
	}//end execute/////////////////////////////////////
	
	
}//end class////////////////////////////////////////////
