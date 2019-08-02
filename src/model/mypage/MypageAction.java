package model.mypage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserDTO;

public class MypageAction {

	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		MypageDTO dto = new MypageDTO();
		HttpSession session = req.getSession();
		dto.setUsercode(((UserDTO)session.getAttribute("loginOk")).getUsercode());
		System.out.println("유져코드 = " + dto.getUsercode());
		MypageDAO dao = MypageDAO.getInstance();
		
		List<MypageDTO> reviewList =  dao.myPageReview(dto.getUsercode()); //마이페이지 리뷰 제목 작성일
		List<MypageDTO> recommentList = dao.myPageRecomment(dto.getUsercode());//마이페이지 댓글내용
		List<MypageDTO> promotionList = dao.myPagepromotion(dto.getUsercode());//마이페이지 홍보문의 제목
		
		req.setAttribute("reviewList", reviewList);
		req.setAttribute("recommentList", recommentList);
		req.setAttribute("promotionList", promotionList);
		
		
		
	}

}//end MypageAction/////////////////////////////////////////
