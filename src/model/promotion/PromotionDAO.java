package model.promotion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import templet.JdbcTemplate;

public class PromotionDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Statement stmt;
	
	public PromotionDAO() {
		// TODO Auto-generated constructor stub
	}
	
	private static PromotionDAO dao = new PromotionDAO();
	
	public static PromotionDAO getInstance() {
		return dao;
	}
	
	private void exit() throws SQLException {
		if (rs != null)
			JdbcTemplate.close(rs);
		if (stmt != null)
			JdbcTemplate.close(stmt);
		if (pstmt != null)
			JdbcTemplate.close(pstmt);
		if (conn != null)
			JdbcTemplate.close(conn);
	}// end exit()
	
	
	public void insertMethod(PromotionDTO dto ) {
		try {
			conn=JdbcTemplate.getConnection();
			String sql = "insert into PROMOTION VALUES(promotion_sq.nextval,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getUsercode());
			pstmt.setString(2, dto.getfTitle());
			pstmt.setDate(3, dto.getfSdate());
			pstmt.setDate(4, dto.getfEdate());
			pstmt.setString(5, dto.getfAddress());
			pstmt.setString(6, dto.getfContents());
			pstmt.setString(7, dto.getfImgpath());
			pstmt.setString(8, dto.getfMainpath());
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}//end insert();
	
	public int rowCount() {
		int cnt = 0;
		try {
			conn= JdbcTemplate.getConnection();
			stmt = conn.createStatement();
			String sql = "select count(*) from promotion";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cnt;
	}
	
	public List<PromotionDTO> lsitMethod(PageDTO pdto){
		List<PromotionDTO> aList = new ArrayList<PromotionDTO>();
		
		try {
			conn = JdbcTemplate.getConnection();
			String sql = "select b.* from (select rownum as rn , a.* from (select * from PROMOTION order by boardkey desc)a)b where b.rn>=?  and b.rn<=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pdto.getStartRow());
			pstmt.setInt(2, pdto.getEndRow());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PromotionDTO dto = new PromotionDTO();
				dto.setBoardkey(rs.getString("boardkey"));
				dto.setUsercode(rs.getInt("usercode"));
				dto.setfTitle(rs.getString("ftitle"));
				dto.setfSdate(rs.getDate("fsdate"));
				dto.setfEdate(rs.getDate("fedate"));
				dto.setfAddress(rs.getString("faddress"));
				dto.setfContents(rs.getString("fcontents"));
				dto.setfImgpath(rs.getString("fimgpath"));
				dto.setfMainpath(rs.getString("fmainpath"));
				dto.setComment(new ArrayList<PromotionCommentDTO>());
				aList.add(dto);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return aList;
	}
	
	public PromotionDTO viewMethod(String boardkey) {
		PromotionDTO dto = new PromotionDTO();
		
		try {
			conn=JdbcTemplate.getConnection();
			String sql = "select * from PROMOTION where boardkey = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.valueOf(boardkey));
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setBoardkey(rs.getString("boardkey"));
				dto.setUsercode(rs.getInt("usercode"));
				dto.setfTitle(rs.getString("ftitle"));
				dto.setfSdate(rs.getDate("fsdate"));
				dto.setfEdate(rs.getDate("fedate"));
				dto.setfAddress(rs.getString("faddress"));
				dto.setfContents(rs.getString("fcontents"));
				dto.setfImgpath(rs.getString("fimgpath"));
				dto.setfMainpath(rs.getString("fmainpath"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dto;
	}//end view
	
	
	public PromotionDTO fileMethod(String boardkey) {
		PromotionDTO dto = new PromotionDTO();
		try {
			conn = JdbcTemplate.getConnection();
			String sql= "select FIMGPATH , FMAINPATH from promotion where boardkey = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardkey);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto.setfImgpath(rs.getString("fimgpath"));
				dto.setfMainpath(rs.getString("fmainpath"));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
	}//end file
	
	public void updateMethod(PromotionDTO dto) {
		
		try {
			conn = JdbcTemplate.getConnection();
			String sql = "update promotion set ftitle = ? ,fsdate = ?, fedate= ? , faddress=?, fcontents =? , fimgpath=?, fmainpath=? where boardkey = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getfTitle());
			pstmt.setDate(2, dto.getfSdate());
			pstmt.setDate(3, dto.getfEdate());
			pstmt.setString(4, dto.getfAddress());
			pstmt.setString(5, dto.getfContents());
			pstmt.setString(6, dto.getfImgpath());
			pstmt.setString(7, dto.getfMainpath());
			pstmt.setString(8, dto.getBoardkey());
			pstmt.executeUpdate();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}//end //////////
	
	public void commentinsert(PromotionCommentDTO dto) {
		
		try {
			conn=JdbcTemplate.getConnection();
			String  sql = "insert into PROMOTIONCOMMENT  VALUES(?,?,?,sysdate,promotion_sq.nextval)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBoardkey());
			pstmt.setString(2, dto.getCommentTitle());
			pstmt.setString(3, dto.getCommentContents());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}//end  commentinsert////////////////////////
	
	public PromotionCommentDTO commentview(int commentcode) {
		PromotionCommentDTO dto = new PromotionCommentDTO();
		System.out.println("답변뷰dao접근");
		try {
			conn = JdbcTemplate.getConnection();
			String sql = "select * from PROMOTIONCOMMENT where commentcode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, commentcode);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto.setCommentTitle(rs.getString("title"));
				dto.setCommentContents(rs.getString("content"));
				dto.setCommentday(rs.getDate("day"));
				dto.setBoardkey(rs.getString("boardkey"));
				dto.setCommentcode(rs.getInt("commentcode"));
				System.out.println("답글 제목 = "+rs.getString("title"));
				System.out.println("답글 내용 = "+rs.getString("content"));
				System.out.println("답글 날짜 = "+rs.getDate("day"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dto;
	}//////////////////end
	
	public void promotionCommentDelete(int commentcode) {
		try {
			conn = JdbcTemplate.getConnection();
			String sql = "delete from PROMOTIONCOMMENT where commentcode= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, commentcode);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//end////////////////////////////////////////////////////
	
	//본글삭제시 밑의 댓글 모두 삭제
	public void promotionAllCommentDelete(String boardkey) {
		try {
			conn = JdbcTemplate.getConnection();
			String sql = "delete from PROMOTIONCOMMENT where boardkey= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardkey);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//end////////////////////////////////////////////////////
	
  public void promotionDelete(String boardkey) {
	  try {
		conn = JdbcTemplate.getConnection();
		String sql = "delete from promotion where boardkey= ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, boardkey);
		pstmt.executeUpdate();
	  } catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			exit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
  }//end ////////////////////////////////////////////////////
	
  public List<PromotionCommentDTO> addComment(){
		List<PromotionCommentDTO> commentList = new ArrayList<PromotionCommentDTO>();
		
		try {
			conn=JdbcTemplate.getConnection();
			String sql = "select * from promotioncomment order by DAY desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PromotionCommentDTO dto = new PromotionCommentDTO();
				dto.setBoardkey(rs.getString("boardkey"));
				dto.setCommentcode(rs.getInt("commentcode"));
				dto.setCommentContents(rs.getString("content"));
				dto.setCommentday(rs.getDate("day"));
				dto.setCommentTitle(rs.getString("title"));
				commentList.add(dto);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return commentList;
	}//////////////////////////////////////////
  
  public PromotionDTO updateForm(String boardkey){
	  PromotionDTO dto = new PromotionDTO();
	  
	  try {
		conn=JdbcTemplate.getConnection();
		String sql = "select * from promotion where boardkey = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, boardkey);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			dto.setfTitle(rs.getString("ftitle"));
			dto.setfSdate(rs.getDate("fsdate"));
			dto.setfEdate(rs.getDate("fedate"));
			dto.setfContents(rs.getString("fcontents"));
			dto.setfAddress(rs.getString("faddress"));
			dto.setfImgpath(rs.getString("fImgpath"));
			dto.setfMainpath(rs.getString("fmainpath"));
		}
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			exit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
	  
	  return dto;
  }//end////////////////////////////////
  
  
  

}//end DAO
