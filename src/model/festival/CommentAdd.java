package model.festival;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentAdd implements FestivalActionImp{
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
			String key = req.getParameter("num");
			String contents = req.getParameter("content");
			int ucd = Integer.parseInt(req.getParameter("ucd")); 
			int fcd = Integer.parseInt(req.getParameter("fcd"));
			
			
			System.out.println(key + " : " + contents + " : " + ucd + " : " + fcd);
			
			CommentDTO dto = new CommentDTO();
			
			dto.setBoardkey(key);
			dto.setRecontents(contents);
			dto.setUsercode(ucd);
			dto.setFcode(fcd);	
			ReviewBoardDAO dao = ReviewBoardDAO.getInstance();
			dao.recommendInsert(dto);
			 
			
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}//end execute()
	
}
