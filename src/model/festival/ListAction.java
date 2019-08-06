package model.festival;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
		//System.out.println(place+","+ date);
		req.setAttribute("aList", dao.getFestList(place, date));
	}
}
