package model.promotion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class PromotionDeleteTwoAction implements PromotionAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("답글삭제 액션접근");
		String boardkey = req.getParameter("boardkey");
		int commentcode = Integer.parseInt(req.getParameter("commentcode"));
		PromotionDAO dao = PromotionDAO.getInstance();
		System.out.println("보드키 = " +boardkey);
		dao.promotionCommentDelete(commentcode);
		
	}

	@Override
	public MultipartRequest executeMulti(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

}
