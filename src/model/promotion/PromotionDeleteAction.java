package model.promotion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class PromotionDeleteAction implements PromotionAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String boardkey = req.getParameter("boardkey");
		int commentcode = Integer.parseInt(req.getParameter("commentcode"));
		PromotionDAO dao = PromotionDAO.getInstance();
		
		dao.promotionCommentDelete(commentcode); // 코멘트 먼저 삭제
		dao.promotionDelete(boardkey); // 문의 삭제
		
		
	}

	@Override
	public MultipartRequest executeMulti(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

}
