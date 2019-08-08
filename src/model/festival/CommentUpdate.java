package model.festival;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentUpdate implements FestivalActionImp{
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		int num = Integer.parseInt(req.getParameter("num"));
		String con = req.getParameter("content");
		
		System.out.println(num + " : " + con + " 탑니다 ");
		
		ReviewBoardDAO dao = ReviewBoardDAO.getInstance();
		dao.recommendUpdate(num,con);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=null;
		try {
			out = resp.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(num);
		
		
		
	}
}
