package model.promotion;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.UserDTO;

public class WriteAction implements PromotionAction{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
			//사용자가 홍보문의의 글을 작성하기위해 입력받은 정보를 저장
			MultipartRequest multi = null;
			String saveDirectory="c:/temp";
			
			File file = new File(saveDirectory);
			if(!file.exists()) {
				file.mkdir();
			}
			int maxPostSize = 1*1000*1000*1000;//1Gb
			
			String encoding = "UTF-8";
			try {
				multi = new MultipartRequest(req, saveDirectory, maxPostSize, encoding, new DefaultFileRenamePolicy());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			HttpSession session = req.getSession();
			int usercode ;
			UserDTO userdto = (UserDTO) session.getAttribute("loginOk");
			usercode = userdto.getUsercode();
		
		PromotionDTO dto = new PromotionDTO();
		PromotionDAO dao = 	PromotionDAO.getInstance();
		
		dto.setfTitle(multi.getParameter("fTitle"));
		dto.setUsercode(usercode);
		dto.setfSdate(Date.valueOf(multi.getParameter("fSdate")));
		dto.setfEdate(Date.valueOf(multi.getParameter("fEdate")));
		dto.setfAddress(multi.getParameter("fAddress"));
		dto.setfContents(multi.getParameter("fContents"));
		dto.setfImgpath(multi.getFilesystemName("fImgpath"));
		dto.setfMainpath(multi.getFilesystemName("fMainpath"));
		
		dao.insertMethod(dto);
			
	}

	@Override
	public MultipartRequest executeMulti(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

}
