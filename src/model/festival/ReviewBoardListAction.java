package model.festival;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ReviewBoardListAction implements BoardActionImp{

	@Override
	public void execute(HttpServletRequest req) {
		ReviewBoardDAO dao=ReviewBoardDAO.getInstance();
		
		String pageNum = req.getParameter("pageNum");
		
		if(pageNum == null || pageNum.equals("null")) {
			pageNum ="1";
			
		}
		int currentPage = Integer.parseInt(pageNum);
		
		String searchKey = req.getParameter("searchKey");	//검색할 속성
		String searchWord = req.getParameter("searchWord");	//검색어 가져오기
		
		HashMap< String, String> map = new HashMap<String, String>();
		map.put("searchKey", searchKey); 
		map.put("searchWord", searchWord);
		
		
		
		int cnt = dao.rowTotalCount(map); //현재 테이블의 전체 레코드 수
		if(cnt>0) {			
			PageDTO pdto = new PageDTO(currentPage , cnt,searchKey , searchWord);
			//System.out.println(pdto.getStartPage()); //1
			//System.out.println(pdto.getEndPage()); //5
			req.setAttribute("aList", dao.listMethod(pdto));
			req.setAttribute("pdto", pdto);//pdto의 값을 넘겨준다.
		}
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

}
