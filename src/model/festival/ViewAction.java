package model.festival;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ViewAction implements FestivalActionImp{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		/*
		 * FestDAO dao = FestDAO.getInstance(); int
		 * fcode=Integer.parseInt(req.getParameter("fcode"));
		 * dao.readCountMethod(fcode); req.setAttribute("dto", dao.getFestView(fcode));
		 * req.setAttribute("rdto", dao.getReview(fcode));
		 */
		
		int code = Integer.parseInt(req.getParameter("fcode"));
		System.out.println(code + " code");
		FestDAO dao = FestDAO.getInstance();
		//글 조회수 증가 추가
		dao.readCount(code);
		FestDTO cList = dao.contents(code);
		// 글조회수 end 
		ReviewBoardDAO dao2 = ReviewBoardDAO.getInstance();
		List<ReviewBoardDTO> rwList = dao2.ReviewSel(code);
		//리뷰게시판
		req.setAttribute("rwList", rwList);
		//축제내부내용
		req.setAttribute("cList", cList);
		
	}
}
