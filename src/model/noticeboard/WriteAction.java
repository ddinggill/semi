package model.noticeboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteAction implements NoticeAction{
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		NoticeDTO dto = new NoticeDTO();
		dto.setTitle(req.getParameter("title"));
		//dto.setContent(req.getParameter("content"));
		
		NoticeDAO dao = NoticeDAO.getInstance();
		dao.insertMethod(dto);
	}//end execute()
}//end class
