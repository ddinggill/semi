package model.festival;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ReviewBoardUpdateProAction implements BoardMultiImp{

	@Override
	public MultipartRequest executeMulti(HttpServletRequest req) {
		MultipartRequest multi = null;
		String saveDirectory = "c:/temp";
		File file = new File(saveDirectory);
		if(!file.exists())
			file.mkdir();
		int maxPostSize = 1000000000;
		String encoding = "UTF-8";
		
		try {
			multi=new MultipartRequest(req, saveDirectory, maxPostSize, encoding, new DefaultFileRenamePolicy());
		} catch (IOException e) {
			e.printStackTrace();
		}
		ReviewBoardDTO dto = new ReviewBoardDTO();
		ReviewBoardDAO dao = ReviewBoardDAO.getInstance();
		
		String boardkey = multi.getParameter("boardkey");
		//board테이블에 첨부파일의 저장여부 검색
		String filename = dao.fileMethod(boardkey);
		//수정 첨부파일이 있으면
		if(multi.getFilesystemName("filename")!= null) {
			//기존 첨부파일이 있으면
			if(filename != null) {
				//board테이블의 첨부파일을 삭제
				File oldFile = new File(saveDirectory, filename);
				oldFile.delete();
			}
			//기존의 첨부파일이 없거나 삭제된 후
			dto.setFilename(multi.getFilesystemName("filename"));
		}else {//첨부파일이 없으면
			if(filename!=null) {
				//기존 첨부파일이 있으면
				dto.setFilename(filename);
			}
		}
		
		dto.setBtitle(multi.getParameter("btitle"));
		dto.setContents(multi.getParameter("contents"));
		dto.setBoardkey(boardkey);
		dao.updateMethod(dto);
		
		return multi;
	}

}
