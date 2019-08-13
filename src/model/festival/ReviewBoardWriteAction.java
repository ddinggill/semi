package model.festival;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/*
 * 첨부파일을 가질 수 있는 후기글을 등록하는 모델
 * 작성자 : 박종현
 * 작성일 : 2019.08.13
 */
public class ReviewBoardWriteAction implements BoardMultiImp{

	@Override
	public MultipartRequest executeMulti(HttpServletRequest req) {
		MultipartRequest multi = null;
		String saveDirectory = "c:/temp"; //첨부파일 저장 주소
		File file = new File(saveDirectory);
		if(!file.exists())
			file.mkdir();
		int maxPostSize = 1000000000; //1GB
		String encoding = "UTF-8";
		
		try {
			multi=new MultipartRequest(req, saveDirectory, maxPostSize, encoding, new DefaultFileRenamePolicy());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ReviewBoardDAO dao = ReviewBoardDAO.getInstance();
		ReviewBoardDTO dto = new ReviewBoardDTO();
		
		dto.setUsercode(Integer.parseInt(multi.getParameter("usercode"))); //유저코드
		dto.setFcode(Integer.parseInt(multi.getParameter("fcode"))); //축제코드
		dto.setBtitle(multi.getParameter("title")); //축제명
		dto.setContents(multi.getParameter("contents")); //축제 내용
		dto.setFilename(multi.getFilesystemName("filename")); //첨부파일
		
		dao.insertMethod(dto);
		return multi;
	}

}
