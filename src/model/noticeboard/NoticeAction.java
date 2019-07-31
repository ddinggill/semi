package model.noticeboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface NoticeAction {
	
	public void execute(HttpServletRequest req, HttpServletResponse resp);
		
}
