package model.festival;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 후기글을 삭제하는 모델
 * 작성자 : 박종현
 * 작성일 : 2019.08.13
 */
public class ReviewBoardDeleteAction implements BoardActionImp{

   @Override
   public void execute(HttpServletRequest req) {
      ReviewBoardDAO dao = ReviewBoardDAO.getInstance();
      String saveDirectory = "c:/temp"; //삭제할 파일의 경로 
      String boardkey = req.getParameter("boardkey"); 
      String filename = dao.fileMethod(boardkey);
      
      if(filename != null) {
         //board테이블의 첨부파일 삭제
         File file = new File(saveDirectory, filename);
         file.delete();
      }
      //후기글에 작성된 댓글 먼저 삭제   
      dao.recommendDelAll(boardkey);
      //글삭제
      dao.deleteMethod(boardkey);
   }

   @Override
   public void execute(HttpServletRequest req, HttpServletResponse resp) {
   }

}