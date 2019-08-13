package model.promotion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class UpdateFormAction implements PromotionAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//홍보문의 글을 사용자가 수정하기 위해 이전의 내용을 가져온다.
		String boardkey = req.getParameter("boardkey");
		PromotionDAO dao = PromotionDAO.getInstance();
		req.setAttribute("dto", dao.viewMethod(boardkey));
		
	}//end

	@Override
	public MultipartRequest executeMulti(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	

}//end
