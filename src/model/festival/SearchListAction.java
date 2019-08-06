package model.festival;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
