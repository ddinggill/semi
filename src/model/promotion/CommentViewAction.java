package model.promotion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class CommentViewAction implements PromotionAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//홍보문의 글의 답변에 대한 정보를 가져온다.
		int commentcode =Integer.parseInt( req.getParameter("commentcode"));
		System.out.println("답변코드= " +commentcode);
	
		PromotionDAO dao = PromotionDAO.getInstance();
		req.setAttribute("dto", dao.commentview(commentcode));
	}

	@Override
	public MultipartRequest executeMulti(HttpServletRequest req) {
		return null;
	}

}
