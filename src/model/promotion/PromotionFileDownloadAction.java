package model.promotion;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class PromotionFileDownloadAction implements PromotionAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		PromotionDAO dao = PromotionDAO.getInstance();
		
		String fImgfile = req.getParameter("fImgpath");
		String fMainfile = req.getParameter("fMainpath");
		
		
	 if(fImgfile !=null) { //첨부이미지 클릭시
		 System.out.println("첨부파일이름 = "+ fImgfile);
		 String imgpath;
		try {
			imgpath = URLEncoder.encode(fImgfile, "UTF-8");
			imgpath=imgpath.replace("+", " ");
			 resp.setContentType("application/octet-stream");
			 
			 resp.setHeader("Content-Disposition",
					   "attachment;filename="+imgpath+";");
			 
				File file = new File("c:/temp/",imgpath);
				
				FileInputStream is = new FileInputStream(file);
				BufferedInputStream bs = new BufferedInputStream(is);
				
				BufferedOutputStream bo = new BufferedOutputStream(resp.getOutputStream());
				
				byte buffer[] = new byte[1024];
				int len = 0;
				while((len=bs.read(buffer))>0) {
					bo.write(buffer, 0, len);
					bo.flush();
				}
				
				bs.close();
				is.close();
				bo.close();
				
				
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
	 }else if(fImgfile == null){ //메인이미지 클릭시
		 System.out.println("메인 파일이름 = "+ fMainfile);
		 String mainpath;
		try {
			mainpath = URLEncoder.encode(fMainfile, "UTF-8");
			mainpath = mainpath.replace("+", " ");
			resp.setContentType("application/octet-stream");
			
			resp.setHeader("Content-Disposition",
					   "attachment;filename="+mainpath+";");
			
			File file = new File("c:/temp/",mainpath);
			
			FileInputStream is = new FileInputStream(file);
			BufferedInputStream bs = new BufferedInputStream(is);
			
			BufferedOutputStream bo = new BufferedOutputStream(resp.getOutputStream());
			
			byte buffer[] = new byte[1024];
			int len = 0;
			while((len=bs.read(buffer))>0) {
				bo.write(buffer, 0, len);
				bo.flush();
			}
			
			bs.close();
			is.close();
			bo.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		 
	 }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//end execute

	@Override
	public MultipartRequest executeMulti(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

}
