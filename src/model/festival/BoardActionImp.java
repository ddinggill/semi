package model.festival;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardActionImp {
	public void execute(HttpServletRequest req);
	
	public void execute(HttpServletRequest req,  HttpServletResponse resp);
}
