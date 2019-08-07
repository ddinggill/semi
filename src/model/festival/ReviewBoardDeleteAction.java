package model.festival;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReviewBoardDeleteAction implements BoardActionImp{

	@Override
	public void execute(HttpServletRequest req) {
		ReviewBoardDAO dao = ReviewBoardDAO.getInstance();
		String saveDirectory = "c:/temp"; //삭제할 파일의 경로 
		String boardkey = req.getParameter("boardkey"); 
		String filename = dao.fileMethod(boardkey);
		
		if(filename != null) {
			//board테이블의 첨부파일 삭제
			File file = new File(saveDirectory, filename);
			file.delete();
		}
		dao.deleteMethod(boardkey);
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
	}

}
