package model.noticeboard;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;


public class DeleteAction implements NoticeAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String boardkey = req.getParameter("boardkey");
		NoticeDAO dao = NoticeDAO.getInstance();
		
		String saveDirectory="c:/temp"; //첨부파일 저정되어진 경로
		//board테이블에 첨부파일의 저장여부 검색
		String filename = dao.fileMethod(boardkey);
		if(filename != null) {
			//board테이블의 첨부파일을 삭제
			File File = new File(saveDirectory,filename);
			File.delete();
		}
		
		//db에서 삭제요청
		dao.deleteMethod(boardkey);
		
		String pageNum = req.getParameter("pageNum");
		int currentPage = Integer.parseInt(pageNum);
		int cnt = dao.rowCount();
		
		//페이징 처리
		if(cnt>0) {
			PageDTO pdto = new PageDTO(currentPage, cnt);
			if(pdto.getEndPage()<currentPage) {
				req.setAttribute("pageNum", currentPage-1);
				System.out.println(req.getAttribute("pageNum"));
			}else {
				req.setAttribute("pageNum", currentPage);
			}
		}
	}

	@Override
	public MultipartRequest executeMulti(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

}
