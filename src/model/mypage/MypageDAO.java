package model.mypage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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
	
	public List<MypageDTO> myPagepromotion(int usercode){
		List<MypageDTO> aList = new ArrayList<MypageDTO>();
			try {
				conn=JdbcTemplate.getConnection();
				String sql= "select * from promotion where usercode = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, usercode);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					MypageDTO mdto = new MypageDTO();	
					mdto.setPromotionTitle(rs.getString("ftitle"));
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
	}//end promotion/////////////////
	
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
	
	
	
}//end DAO//////////////////////////////////////////////////////
