package model.promotion;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UpdateProAction implements PromotionAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
	
			
	}//end

	@Override
	public MultipartRequest executeMulti(HttpServletRequest req) {
		//사용자가 홍보문의의 글을 수정한다.
		System.out.println("업데이트 프로 접근");
		MultipartRequest multi = null;
		String saveDirectory="c:/temp"; //첨부파일 저정할 경로
		
		//파일저장할 temp폴더가 없을시 폴더를 만들어라
		File file = new File(saveDirectory);
		if(!file.exists()) {
			file.mkdir();
		}
		int maxPostSize = 1*1000*1000*1000;
		String encoding = "UTF-8";
		
		try {
			multi = new MultipartRequest(req, saveDirectory, maxPostSize, encoding, new DefaultFileRenamePolicy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PromotionDTO dto = new PromotionDTO();
		PromotionDAO dao = PromotionDAO.getInstance();
		String boardkey = multi.getParameter("boardkey");
		PromotionDTO filedto = dao.fileMethod(boardkey);
		System.out.println("메인 이미지파일 = "+filedto.getfMainpath());
		System.out.println("첨부이미지 파일 = "+filedto.getfImgpath());
		
		//메인 첨부파일관련 수정할 메인 첨부파일이 있으면
		if(multi.getFilesystemName("fMainpath")!=null) {
			//promotion기존의 메인첨부파일 삭제
			if(filedto.getfMainpath() != null) {
				File oldFile = new File(saveDirectory, filedto.getfMainpath());
				oldFile.delete();
			}
			dto.setfMainpath(multi.getFilesystemName("fMainpath"));
			System.out.println("파일추가 : "+ multi.getFilesystemName("fMainpath"));
			
		}else {//수정파일이 없으면
			if(filedto.getfMainpath() != null){
				dto.setfMainpath(filedto.getfMainpath());
			}
		}
		
		//일반 첨부파일관련 수정할 메인 첨부파일이 있으면
		if(multi.getFilesystemName("fImgpath")!=null) {
			//promotion기존의 일반첨부파일 삭제
			if(filedto.getfImgpath() != null) {
				File oldFile = new File(saveDirectory, filedto.getfImgpath());
				oldFile.delete();
			}
			dto.setfImgpath(multi.getFilesystemName("fImgpath"));
			System.out.println("파일추가 : "+ multi.getFilesystemName("fImgpath"));
			
		}else {//수정파일이 없으면
			if(filedto.getfImgpath() != null){
				dto.setfImgpath(filedto.getfImgpath());
			}
		}
		System.out.println(boardkey);
		dto.setBoardkey(boardkey);
		dto.setfTitle(multi.getParameter("fTitle"));
		dto.setfSdate(Date.valueOf(multi.getParameter("fSdate")));
		dto.setfEdate(Date.valueOf(multi.getParameter("fEdate")));
		dto.setfAddress(multi.getParameter("fAddress"));
		dto.setfContents(multi.getParameter("fContents"));
		
		dao.updateMethod(dto);
		
		return multi;
		
	}

}//end
