package model.promotion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class PromotionDeleteAction implements PromotionAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
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
