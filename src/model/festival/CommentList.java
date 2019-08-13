package model.festival;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import model.UserDTO;

public class CommentList implements FestivalActionImp{
   
   @Override
   public void execute(HttpServletRequest req, HttpServletResponse resp) {
      String key = req.getParameter("num");
      
      //댓글에서 수정 삭제 보기시 비회원의 기본값  -1 처리  
      int conUser = -1;
      
      //본인이 댓글 쓴 글 수정,삭제 버튼 처리위해  유저코드 매칭 처리 
      UserDTO udto = (UserDTO)req.getSession().getAttribute("loginOk");
      if(udto !=null )
         conUser = udto.getUsercode();

      ReviewBoardDAO dao = ReviewBoardDAO.getInstance();
      List<CommentDTO> list = dao.recommendList(key);
      JSONArray arr = new JSONArray();
      
      for (CommentDTO dto : list) {
         
         JSONObject obj = new JSONObject();
         obj.put("rkey", dto.getRekey());
         obj.put("nm", dto.getUserName());
         obj.put("con", dto.getRecontents());
         obj.put("usercode", dto.getUsercode());
         obj.put("conUser", conUser);
         arr.put(obj);
         System.out.println(arr);
      }
      
      resp.setContentType("text/json;charset=utf-8");
      PrintWriter out = null;
      try {
         out = resp.getWriter();
      } catch (IOException e) {
         e.printStackTrace();
      }
      
      out.print(arr);
      
      
   }
}