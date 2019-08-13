package model.promotion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class ViewAction implements PromotionAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//홍보문의 글을 확인을 위해 글의 정보를 가져옴
		String boardkey = req.getParameter("boardkey");
		System.out.println(boardkey);
		PromotionDAO dao = PromotionDAO.getInstance();
		req.setAttribute("dto", dao.viewMethod(boardkey));
		
	}//end

	@Override
	public MultipartRequest executeMulti(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
