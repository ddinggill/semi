package model.mypage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserDTO;
import model.promotion.PromotionCommentDTO;
import model.promotion.PromotionDTO;

public class MypageAction {

	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		MypageDTO dto = new MypageDTO();
		HttpSession session = req.getSession();
		dto.setUsercode(((UserDTO)session.getAttribute("loginOk")).getUsercode()); //세션에 담겨있는 유저의 유저코드를 dto에 담는다.
		System.out.println("유져코드 = " + dto.getUsercode());
		MypageDAO dao = MypageDAO.getInstance();
		
		List<MypageDTO> reviewList =  dao.myPageReview(dto.getUsercode()); //마이페이지 리뷰 제목 작성일과 글의 기본키를 가져옴
		List<MypageDTO> recommentList = dao.myPageRecomment(dto.getUsercode());//마이페이지 댓글내용 댓글을 쓴 글의 기본키를 가져옴
		List<PromotionDTO> promotionList = dao.myPagepromotion(dto.getUsercode());//마이페이지 홍보문의 제목 과 글의 기본키를 가져옴
		List<PromotionCommentDTO> commentList = dao.addComment();
		System.out.println(promotionList.size());
		System.out.println(commentList.size());
		for(PromotionDTO pdto : promotionList) {
			for(PromotionCommentDTO cdto : commentList) {
				if(pdto.getBoardkey().equals(cdto.getBoardkey())) {//홍보문의 글의 기본키와 답변의 보드키를 비교 후 맞을경우  홍보의 dto에 담는다.
					pdto.getComment().add(cdto);
					System.out.println(cdto.getCommentContents());
				}
			}
		}
		
		req.setAttribute("reviewList", reviewList);
		
		req.setAttribute("recommentList", recommentList);
		req.setAttribute("promotionList", promotionList);
		
		
		
		
	}

}//end MypageAction/////////////////////////////////////////
