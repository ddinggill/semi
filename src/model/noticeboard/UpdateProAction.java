package model.noticeboard;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UpdateProAction implements NoticeAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
	}//end execute()

	@Override
	public MultipartRequest executeMulti(HttpServletRequest req) {
		
		MultipartRequest multi = null;
		String saveDirectory="c:/temp"; //첨부파일 저정할 경로
		//파일저장할 temp폴더가 없을시 폴더를 만들어라
		File file = new File(saveDirectory);
		if(!file.exists())
			file.mkdir();
		
		int maxPostSize = 1*1000*1000*1000; //1GB
		String encoding = "UTF-8";
		
		try {
			multi = new MultipartRequest(req, saveDirectory, maxPostSize, encoding, new DefaultFileRenamePolicy());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		NoticeDTO dto = new NoticeDTO();
		NoticeDAO dao = NoticeDAO.getInstance();
		
		String boardkey = multi.getParameter("boardkey");
		//board테이블에 첨부파일의 저장여부 검색
		String filename = dao.fileMethod(boardkey);
		//수정 첨부파일이 있으면
		if(multi.getFilesystemName("filename") != null) {
			//기존 첨부파일이 있으면
			if(filename != null) {
				//board테이블의 첨부파일을 삭제
				File oldFile = new File(saveDirectory,filename);
				oldFile.delete();
			}
			dto.setFilename(multi.getFilesystemName("filename"));
		}else {//수정 첨부파일이 없으면
			//기존 첨부파일이 있으면
			if(filename != null) {
				dto.setFilename(filename);
			}
		}
		dto.setTitle(multi.getParameter("title"));
		dto.setContents(multi.getParameter("contents"));
		dto.setBoardkey(boardkey);
		
		dao.updateMethod(dto);
		
		return multi;
	}

}
