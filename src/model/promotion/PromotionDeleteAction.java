package model.promotion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class PromotionDeleteAction implements PromotionAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//사용자가 본인이 작성한 홍보문의글을 삭제시
		String boardkey = req.getParameter("boardkey");
		PromotionDAO dao = PromotionDAO.getInstance();
		
		dao.promotionAllCommentDelete(boardkey);
		dao.promotionDelete(boardkey); // 문의 삭제
		
		
	}

	@Override
	public MultipartRequest executeMulti(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

}
