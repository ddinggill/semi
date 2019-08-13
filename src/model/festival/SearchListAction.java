package model.festival;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 지역과 기간을 선택하여 보길 원하는 축제 리스트를 보여주는 모델
 * 작성자 : 박종현
 * 작성일 : 2019.08.13
 */
public class SearchListAction implements FestivalActionImp{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("SearchListAction");
		FestDAO dao = FestDAO.getInstance();
		String place = req.getParameter("place");
		String date = req.getParameter("date");
		List<FestDTO> aList = dao.getFestList(place, date);
		req.setAttribute("aList", aList);
	}
}
