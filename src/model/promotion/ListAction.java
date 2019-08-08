package model.promotion;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class ListAction implements PromotionAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {

		PromotionDAO dao = PromotionDAO.getInstance();
		
		String pageNum = req.getParameter("pageNum");
		
		if(pageNum==null) {
			pageNum="1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int totalCount = dao.rowCount();
		PageDTO pdto =new PageDTO(currentPage,totalCount);
		List<PromotionCommentDTO> commentList = dao.addComment();
		List<PromotionDTO> aList = dao.lsitMethod(pdto);
		
		
		for(PromotionDTO prodto : aList) {
			for(PromotionCommentDTO cdto : commentList) {
				if(prodto.getBoardkey().equals(cdto.getBoardkey())) {
					prodto.getComment().add(cdto);
					System.out.println(cdto.getCommentContents());
				}
			}
		}
		
		req.setAttribute("aList", aList);
		req.setAttribute("pdto", pdto);
		
	}//end execute()

	@Override
	public MultipartRequest executeMulti(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}//end
