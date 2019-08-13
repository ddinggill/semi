package model.mypage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.promotion.PromotionCommentDTO;
import model.promotion.PromotionDTO;
import templet.JdbcTemplate;

public class MypageDAO {
		
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	private static MypageDAO dao = new MypageDAO();
	private MypageDAO() {}
	public static MypageDAO getInstance() {
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
	
	 //사용자가 쓴 후기글을 유저코드로 비교해 가져온다.
	public List<MypageDTO> myPageReview(int usercode){
		List<MypageDTO> aList = new ArrayList<MypageDTO>();
			try {
				conn=JdbcTemplate.getConnection();
				String sql= "select * from REVIEWBOARD where usercode = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, usercode);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					MypageDTO mdto = new MypageDTO();
					mdto.setReviewTitle(rs.getString("title"));
					mdto.setReviewDate(rs.getDate("day"));
					mdto.setReviewcode(rs.getString("boardkey"));
					aList.add(mdto);
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
	}//end review//////////////////////////////////////////
	
	//사용자가 쓴 댓글을 유저코드로 비교해 가져온다.
	public List<MypageDTO> myPageRecomment(int usercode){
		List<MypageDTO> aList = new ArrayList<MypageDTO>();
			try {
				conn=JdbcTemplate.getConnection();
				String sql= "select * from f_recomment where usercode = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,usercode);
				
				rs = pstmt.executeQuery();
				while(rs.next()) {
					MypageDTO mdto = new MypageDTO();
					mdto.setComment(rs.getString("fcontents"));
					mdto.setReviewcode(rs.getString("boardkey"));
					aList.add(mdto);
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
	}//end recomment/////////////////
	
	//회원정보를  수정  
	public void mypageInfoUpdate(int usercode , MypageUpdateDTO dto) {
		
		try {
			conn= JdbcTemplate.getConnection();
			String sql = "UPDATE member SET PASSWORD= ? ,NAME= ? ,NICKNAME= ? ,USEREMAIL= ? where usercode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPassword());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getNickname());
			pstmt.setString(4, dto.getEmail());
			pstmt.setInt(5, usercode);
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
		
	}//end /////////////////////////////
	
	//사용자가 쓴 홍보문의글을 유저코드로 비교해 가져온다.
	public List<PromotionDTO> myPagepromotion(int usercode){
		List<PromotionDTO> aList = new ArrayList<PromotionDTO>();
		
		try {
			conn=JdbcTemplate.getConnection();
			String sql = "select * from promotion where usercode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, usercode);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PromotionDTO dto = new PromotionDTO();
				dto.setBoardkey(rs.getString("boardkey"));
				dto.setUsercode(usercode);
				dto.setfTitle(rs.getString("fTitle"));
				dto.setfSdate(rs.getDate("fSdate"));
				dto.setfEdate(rs.getDate("fEdate"));
				dto.setfAddress(rs.getString("fAddress"));
				dto.setfImgpath(rs.getString("fImgpath"));
				dto.setfMainpath(rs.getString("fMainpath"));
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
	
	//모든 답변글의 정보를 리스트에 담는다.
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
	}
	
	
	
	
}//end DAO//////////////////////////////////////////////////////
