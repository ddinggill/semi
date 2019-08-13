package model.festival;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 후기글의 내용을 수정하기 위해 기존의 정보를 수정폼으로 이동시키는 모델
 * 작성자 : 박종현
 * 작성일 : 2019.08.13
 */
public class ReviewBoardUpdateFormAction implements BoardActionImp{

	@Override
	public void execute(HttpServletRequest req) {
		// TODO Auto-generated method stub
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String boardkey = req.getParameter("boardkey");
		ReviewBoardDAO dao = ReviewBoardDAO.getInstance();
		req.setAttribute("dto", dao.oneSelect(boardkey));
	}

}
