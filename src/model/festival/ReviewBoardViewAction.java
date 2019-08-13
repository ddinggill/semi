package model.festival;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 선택된 후기의 상세 내용을 보여주는 모델
 * 작성자 : 박종현
 * 작성일 : 2019.08.13
 */
public class ReviewBoardViewAction implements BoardActionImp{

	@Override
	public void execute(HttpServletRequest req) {
		String boardkey = req.getParameter("boardkey");
		ReviewBoardDAO dao = ReviewBoardDAO.getInstance();
		req.setAttribute("dto", dao.viewMethod(boardkey));
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
	}

}
