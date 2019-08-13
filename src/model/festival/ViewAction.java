package model.festival;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 축제의 상세 내용을 보여주는 모델
 * 작성자 : 박종현
 * 작성일 : 2019.08.13
 */
public class ViewAction implements FestivalActionImp{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		int code = Integer.parseInt(req.getParameter("fcode"));
		FestDAO dao = FestDAO.getInstance();
		//글 조회수 1 증가
		dao.readCount(code);
		FestDTO cList = dao.contents(code);
		ReviewBoardDAO dao2 = ReviewBoardDAO.getInstance();
		List<ReviewBoardDTO> rwList = dao2.ReviewSel(code);
		//후기 게시판 내용
		req.setAttribute("rwList", rwList);
		//축제 상세 내용
		req.setAttribute("cList", cList);
		
	}
}
