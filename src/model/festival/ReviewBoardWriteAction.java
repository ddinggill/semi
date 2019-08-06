package model.festival;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class ReviewBoardWriteAction implements BoardMultiImp{

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
		
		ReviewBoardDAO dao = ReviewBoardDAO.getInstance();
		ReviewBoardDTO dto = new ReviewBoardDTO();
		
		//pstmt.setString(5, dto.getFilename());
		
		dto.setUsercode(Integer.parseInt(multi.getParameter("usercode")));
		dto.setFcode(Integer.parseInt(multi.getParameter("fcode")));
		dto.setBtitle(multi.getParameter("title"));
		dto.setContents(multi.getParameter("contents"));
		dto.setFilename(multi.getFilesystemName("filename"));
		
		dao.insertMethod(dto);
		return multi;
	}

}
