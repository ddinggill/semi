package model.festival;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/*
 * 후기글의 내용을 수정하는 모델
 * 작성자 : 박종현
 * 작성일 : 2019.08.13
 */
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
		//수정하는 첨부파일이 있으면
		if(multi.getFilesystemName("filename")!= null) {
			//기존 첨부파일이 있으면
			if(filename != null) {
				//board테이블의 첨부파일을 삭제
				File oldFile = new File(saveDirectory, filename);
				oldFile.delete();
			}
			//기존의 첨부파일이 없거나 삭제된 후
			dto.setFilename(multi.getFilesystemName("filename"));
		}else {//수정하는 첨부파일이 없으면
			if(filename!=null) {
				//기존 첨부파일이 있으면
				dto.setFilename(filename);
			}
		}
		
		dto.setBtitle(multi.getParameter("btitle")); //후기명
		dto.setContents(multi.getParameter("contents")); //후기내용
		dto.setBoardkey(boardkey); //후기글 코드
		dao.updateMethod(dto);
		
		return multi;
	}
}
