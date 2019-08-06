package model.join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class joinAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		joinDTO dto = new joinDTO();
		dto.setUserid(req.getParameter("userid"));
		dto.setName(req.getParameter("name"));
		dto.setNickname(req.getParameter("nickname"));
		dto.setPassword(req.getParameter("password"));
		dto.setPhonenumber(req.getParameter("phonenumber"));
		dto.setUsermail(req.getParameter("useremail"));
		
		joinDAO dao = joinDAO.getInstance();
		
		int rs = dao.insert(dto);
		if (rs == 1) {
			req.setAttribute("joinOK", 1);
		} 

	}
}
