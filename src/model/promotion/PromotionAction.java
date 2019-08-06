package model.promotion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public interface PromotionAction {

public void execute(HttpServletRequest req, HttpServletResponse resp);
	
	public MultipartRequest executeMulti(HttpServletRequest req);
}
