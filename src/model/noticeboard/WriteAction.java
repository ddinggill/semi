package model.noticeboard;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class WriteAction implements NoticeAction{
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
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
		
		dto.setUsercode(Integer.parseInt(multi.getParameter("usercode"))); 
		dto.setTitle(multi.getParameter("title"));
		dto.setContents(multi.getParameter("contents"));
		dto.setFilename(multi.getFilesystemName("upload"));
		
		dao.insertMethod(dto);
	}//end execute()

	@Override
	public MultipartRequest executeMulti(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}
}//end class
