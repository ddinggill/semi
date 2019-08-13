package model.festival;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 인기 축제 리스트를 보여주는 모델
 * 작성자 : 박종현
 * 작성일 : 2019.08.13
 */
public class HotListAction implements FestivalActionImp{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("HotListAction");
		FestDAO dao = FestDAO.getInstance();
		req.setAttribute("aList", dao.getHotList());
	}
}
