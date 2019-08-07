package model.festival;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
