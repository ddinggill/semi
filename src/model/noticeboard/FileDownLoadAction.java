package model.noticeboard;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;


public class FileDownLoadAction implements NoticeAction{
	public void execute(HttpServletRequest req, 
			HttpServletResponse resp)  {
		
		//int num = Integer.parseInt(req.getParameter("num"));
		NoticeDAO dao=NoticeDAO.getInstance();
		//String filename=dao.fileMethod(num);
		String filename = req.getParameter("filename");
		//System.out.println("filename"+filename);
		
		try {
			//파일명 한글처리
			String convName=URLEncoder.encode(filename,"UTF-8");
			convName=convName.replace("+", " ");
			
			//컨텐트 타입(application -> octet-stream 파싱) ex) text/html, text/json와 같은 의미
			resp.setContentType("application/octet-stream");
			
			//다운로드 파일명
			resp.setHeader("Content-Disposition",
					   "attachment;filename="+convName+";");
			
			File file=new File("c:/temp/",filename);
			
			FileInputStream is=new FileInputStream(file);
			BufferedInputStream bs=new BufferedInputStream(is);
			
			BufferedOutputStream bo=
					new BufferedOutputStream(resp.getOutputStream());
			
			byte buffer[]=new byte[1024];
			int len=0;
			while((len=bs.read(buffer))>0) {
				bo.write(buffer,0,len);
				bo.flush();
			}
			
			bs.close();
			is.close();
			bo.close();			
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//end execute()

	@Override
	public MultipartRequest executeMulti(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

}//end class










