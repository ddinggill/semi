package model.noticeboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class ListAction implements NoticeAction{

	public void execute(HttpServletRequest req, HttpServletResponse resp){
		NoticeDAO dao = NoticeDAO.getInstance();
		
		String pageNum = req.getParameter("pageNum");
		//list를 처음 불러올때
		if(pageNum==null)
			pageNum="1";
		int currentPage = Integer.parseInt(pageNum);
		int totalCount = dao.rowCount();
		PageDTO pdto = new PageDTO(currentPage,totalCount);
		List<NoticeDTO> aList = dao.listMethod(pdto);
		req.setAttribute("aList", aList);
		req.setAttribute("pdto", pdto);
	}//end execute()

	@Override
	public MultipartRequest executeMulti(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}
}
