package model.noticeboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;


public class ViewAction implements NoticeAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String boardkey = req.getParameter("boardkey");
		NoticeDAO dao =  NoticeDAO.getInstance();
		req.setAttribute("dto", dao.viewMethod(boardkey));
	}

	@Override
	public MultipartRequest executeMulti(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

}
