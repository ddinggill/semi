package model.festival;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
