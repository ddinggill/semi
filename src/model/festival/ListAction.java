package model.festival;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 모든 축제 리스트를 보여주는 모델
 * 작성자 : 박종현
 * 작성일 : 2019.08.13
 */
public class ListAction implements FestivalActionImp{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("ListAction");
		FestDAO dao = FestDAO.getInstance();
		String place = req.getParameter("place");
		String date = req.getParameter("date");
		if(place == null || place.equals("null"))
			place = "0";
		if(date == null || date.equals("null"))
			date = "0";
		req.setAttribute("aList", dao.getFestList(place, date));
	}
}
