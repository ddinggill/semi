package model.noticeboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateProAction implements NoticeAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		NoticeDTO dto = new NoticeDTO();
		//dto.setNum(Integer.parseInt(req.getParameter("num")));
		dto.setTitle(req.getParameter("title"));
		//dto.setContent(req.getParameter("content"));
		
		NoticeDAO dao = NoticeDAO.getInstance();
		dao.updateMethod(dto);
		
	}//end execute()

}
