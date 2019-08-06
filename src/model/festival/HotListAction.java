package model.festival;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HotListAction implements FestivalActionImp{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("HotListAction");
		FestDAO dao = FestDAO.getInstance();
		req.setAttribute("aList", dao.getHotList());
	}
}
