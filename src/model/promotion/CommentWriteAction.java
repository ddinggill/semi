package model.promotion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class CommentWriteAction implements PromotionAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String boardkey = req.getParameter("boardkey");
		System.out.println("답변글 보드키 = " + boardkey);
		PromotionDAO dao = PromotionDAO.getInstance();
		PromotionCommentDTO dto = new PromotionCommentDTO();
		dto.setBoardkey(boardkey);
		dto.setCommentContents(req.getParameter("contents"));
		dto.setCommentTitle(req.getParameter("title"));
		System.out.println("답글내용 = " + dto.getCommentContents());
		System.out.println("답글 제목 = "+ dto.getCommentTitle());
		
		dao.commentinsert(dto);
		
		
	}

	@Override
	public MultipartRequest executeMulti(HttpServletRequest req) {
		return null;
	}

	
	
	
}
