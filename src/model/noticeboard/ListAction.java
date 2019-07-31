package model.noticeboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListAction implements NoticeAction{

	public void execute(HttpServletRequest req, HttpServletResponse resp){
		NoticeDAO dao = NoticeDAO.getInstance();
		
		String pageNum = req.getParameter("pageNum");
		//System.out.println("pageNum:"+pageNum);
		//System.out.println(pageNum==null);
		//list를 처음 불러올때
		if(pageNum==null)
			pageNum="1";
		int currentPage = Integer.parseInt(pageNum);
		int totalCount = dao.rowCount();
		PageDTO pdto = new PageDTO(currentPage,totalCount);
		System.out.println("totalpage:" + pdto.getTotalPage());
		System.out.println("startpage:" + pdto.getStartPage());
		System.out.println("endpage:" + pdto.getEndPage());
		List<NoticeDTO> aList = dao.listMethod(pdto);
		req.setAttribute("aList", aList);
		req.setAttribute("pdto", pdto);
	}//end execute()
}
