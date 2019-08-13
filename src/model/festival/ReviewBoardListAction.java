package model.festival;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 모든 후기 리스트를 보여주는 모델
 * 작성자 : 박종현
 * 작성일 : 2019.08.13
 */
public class ReviewBoardListAction implements BoardActionImp{

	@Override
	public void execute(HttpServletRequest req) {
		ReviewBoardDAO dao=ReviewBoardDAO.getInstance();
		
		// 현재 페이지의 과거 정보가 없을때 1로 초기화하여 현재 페이지로 적용 
		String pageNum = req.getParameter("pageNum"); 
		if(pageNum == null || pageNum.equals("null")) {
			pageNum ="1"; 
		}
		int currentPage = Integer.parseInt(pageNum);
		
		String searchKey = req.getParameter("searchKey");	//검색할 속성
		String searchWord = req.getParameter("searchWord");	//검색어 
		
		HashMap< String, String> map = new HashMap<String, String>();
		map.put("searchKey", searchKey); 
		map.put("searchWord", searchWord);
		
		
		
		int cnt = dao.rowTotalCount(map); // 현재 보여지는 모든 레코드 수
		if(cnt>0) {			
			PageDTO pdto = new PageDTO(currentPage , cnt,searchKey , searchWord);
			req.setAttribute("aList", dao.listMethod(pdto)); // 후기 리스트
			req.setAttribute("pdto", pdto); // 페이지 
		}
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
	}

}
