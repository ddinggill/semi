package model.festival;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
		String saveDirectory="C:/Users/user1/git/semi/WebContent/images";

				
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
		  
		  String sdate = multi.getParameter("sdate"); //축제시작일자
		  String edate = multi.getParameter("edate"); //축제종료일자
		  
		  dto.setFaddress(multi.getParameter("address")); //축제주소
		  dto.setFtitle(multi.getParameter("title"));  // 축제제목
		  dto.setFloc(Integer.parseInt(multi.getParameter("loc"))); //축제지역코드
		  dto.setFcontents(multi.getParameter("contents")); //축제내용
		  dto.setFmap(multi.getParameter("fmap")); //축제 구글맵지도
		  dto.setFmainpath(multi.getFilesystemName("mainImg")); //컨텐츠 안에 mainImg가 보일 내용
		  dto.setFimgpath(multi.getFilesystemName("subImg"));  //subimg가 보일내용
			
		  dao.insertFestival(dto,sdate,edate);
			 

		return null;
			
		 
	}

}
