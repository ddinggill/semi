package model.promotion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class PromotionUpdateAction implements PromotionAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//홍보문의 글을 관리자가 등록하기 위해 정보를 가지고 축제등록 폼으로 정보를 전달
		System.out.println("등록 액션 접근");
		 PromotionDTO dto = new PromotionDTO();
		 PromotionDAO dao = PromotionDAO.getInstance();
		 String boardkey = req.getParameter("boardkey");
		 System.out.println("문의글 업데이트 보드키 = " + boardkey);
		 req.setAttribute("dto", dao.updateForm(boardkey));
		
	}

	@Override
	public MultipartRequest executeMulti(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

}
