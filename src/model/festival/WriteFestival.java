package model.festival;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;



public class WriteFestival {

	
	
	
	
	
	public MultipartRequest execute(HttpServletRequest req, HttpServletResponse resp) {
		MultipartRequest multi = null;
		//저장경로
		String saveDirectory="C:/study/workspace/semipj/WebContent/festival/img";
		//C:/study/workspace/SemiPJ/WebContent/Festival/img

				
		File file = new File(saveDirectory);
		//저장경로없으면 만들기
		if(!file.exists())
			file.mkdir();
		
		int maxPostSize = 1*1000*1000*1000; //1GB
		String encoding = "UTF-8";
		
		try {
			multi = new MultipartRequest(req, saveDirectory, maxPostSize, encoding, new DefaultFileRenamePolicy());
		} catch (IOException e) {
			e.printStackTrace();
		}

		
			
		  FestDAO dao = FestDAO.getInstance(); 
		  FestDTO dto = new FestDTO(); 
		  
		  SimpleDateFormat trans = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		  Date csdate = transFormat(multi.getParameter("sdate"));
		  Date cedate = transFormat(multi.getParameter("sdate"));
			
		  dto.setFaddress(multi.getParameter("address"));
		  dto.setFtitle(multi.getParameter("title"));
		  dto.setFsdate(csdate);
		  dto.setFedate(cedate);
		  dto.setFcontents(multi.getParameter("contents")); 
		  dto.setFmainpath(multi.getFilesystemName("mainImg")); //컨텐츠 안에 mainImg가 보일 내용
		  dto.setFimgpath(multi.getFilesystemName("subImg"));  //subimg가 보일내용
		  
		  dao.insertFestival(dto);
		 
		return null;
	}

	private Date transFormat(String parameter) {
		// TODO Auto-generated method stub
		return null;
	}
}
