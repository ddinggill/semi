package model.noticeboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateFormAction implements NoticeAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		int num = Integer.parseInt(req.getParameter("num"));
		NoticeDAO dao = NoticeDAO.getInstance();
		req.setAttribute("dto", dao.oneSelect(num));
	}//end execute()
	
}
