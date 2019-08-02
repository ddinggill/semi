package model.noticeboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public interface NoticeAction {
	
	public void execute(HttpServletRequest req, HttpServletResponse resp);
	
	public MultipartRequest executeMulti(HttpServletRequest req);
		
}
