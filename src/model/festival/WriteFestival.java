package model.festival;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/*
 * 축제를 등록하는 모델
 * 작성자 : 박종현
 * 작성일 : 2019.08.13
 */
public class WriteFestival {

	public MultipartRequest execute(HttpServletRequest req, HttpServletResponse resp) {
		MultipartRequest multi = null;

		// 저장경로
		String saveDirectory = "C:/Users/user1/git/semi/WebContent/images";
		// C:/study/workspace/SemiPJ/WebContent/Festival/img


		File file = new File(saveDirectory);
		// 저장경로없으면 만들기
		if (!file.exists())
			file.mkdir();

		int maxPostSize = 1 * 1000 * 1000 * 1000; // 1GB
		String encoding = "UTF-8";

		try {
			multi = new MultipartRequest(req, saveDirectory, maxPostSize, encoding, new DefaultFileRenamePolicy());
		} catch (IOException e) {
			e.printStackTrace();
		}

		FestDAO dao = FestDAO.getInstance();
		FestDTO dto = new FestDTO();
		String sdate = multi.getParameter("sdate"); //축제 시작일
		String edate = multi.getParameter("edate"); //축제 종료일

		dto.setFaddress(multi.getParameter("address")); //축제 주소
		dto.setFtitle(multi.getParameter("title")); //축제명
		dto.setFloc(Integer.parseInt(multi.getParameter("loc"))); //축제 지역코드
		dto.setFcontents(multi.getParameter("contents")); //축제 내용
		dto.setFmap(multi.getParameter("fmap")); //축제의 구글맵 주소
		System.out.println(multi.getParameter("fmap") + " : 지도주소");
		dto.setFmainpath(multi.getFilesystemName("mainImg")); // 컨텐츠 안에 mainImg가 보일 내용
		dto.setFimgpath(multi.getFilesystemName("subImg")); // subimg가 보일내용

		dao.insertFestival(dto, sdate, edate);


		return null;
	}
}
