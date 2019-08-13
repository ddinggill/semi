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
		//축제 내용보기 클릭시 view 처리 
		

		int code = Integer.parseInt(req.getParameter("fcode")); //축제코드

		FestDAO dao = FestDAO.getInstance();
		
		//글 조회수 증가 추가

		dao.readCount(code);
		
		//내부컨텐츠 리스트 불러오기
		FestDTO cList = dao.contents(code);

		ReviewBoardDAO dao2 = ReviewBoardDAO.getInstance();
		//해당축제 후기글 불러오기
		List<ReviewBoardDTO> rwList = dao2.ReviewSel(code);

		//후기 게시판 내용
		req.setAttribute("rwList", rwList);
		//축제 상세 내용

		req.setAttribute("cList", cList);
		
	}
}
