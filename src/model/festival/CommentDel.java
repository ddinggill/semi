package model.festival;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentDel implements FestivalActionImp{
   @Override
   public void execute(HttpServletRequest req, HttpServletResponse resp) {
      if (!(req.getParameter("rkey").equals("undefined"))) {
         
         int num = Integer.parseInt(req.getParameter("rkey"));
         ReviewBoardDAO dao = ReviewBoardDAO.getInstance();
         dao.recommendDel(num);
         
         resp.setContentType("text/html;charset=utf-8");
         PrintWriter out = null;
         
         try {
            out = resp.getWriter();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         out.print(num);
      }
   
   }
}