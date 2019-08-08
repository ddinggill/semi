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
		String saveDirectory="C:/study/workspace/semi/WebContent/images";
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
		  
		  String sdate = multi.getParameter("sdate");
		  String edate = multi.getParameter("edate");
		  
		  dto.setFaddress(multi.getParameter("address"));
		  dto.setFtitle(multi.getParameter("title"));
		/*
		 * dto.setFsdate(multi.getParameter("sdate"));
		 * dto.setFedate(multi.getParameter("edate"));
		 */
		  dto.setFcontents(multi.getParameter("contents"));
		  dto.setFmap(multi.getParameter("fmap"));
		  System.out.println(multi.getParameter("fmap") + " : 지도주소");
		  dto.setFmainpath(multi.getFilesystemName("mainImg")); //컨텐츠 안에 mainImg가 보일 내용
		  dto.setFimgpath(multi.getFilesystemName("subImg"));  //subimg가 보일내용
			
		  dao.insertFestival(dto,sdate,edate );
			 

		
		return null;
			
		  
		 
	}

	private Date transFormat(String parameter) {
		// TODO Auto-generated method stub
		return null;
	}
}
