package model.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import templet.JdbcTemplate;

public class MainDAO {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static MainDAO dao = new MainDAO();
	private MainDAO() {}
	
	public static MainDAO getInstance() {
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

	//최근 작성된 공지사항 6개를 담아서 보냄
	public List<NoticeDTO> lastNoticeBoard(){
		
		List<NoticeDTO> aList = new ArrayList<NoticeDTO>();
		try {
			conn=JdbcTemplate.getConnection();
			 String sql = "select a.boardkey, a.title ,a.day from (select * from NOTICEBOARD order by day desc)a where rownum <= 6";		 
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println(sql);
			while(rs.next()) {
				NoticeDTO dto = new NoticeDTO();
				dto.setBoardkey(rs.getString("boardkey"));
				dto.setTitle(rs.getString("title"));
				dto.setDay(rs.getDate("day"));
				
				aList.add(dto);
			}
			System.out.println("공지사항 DAO");
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
	}/////////////////////최근공지사항//////////////////////////
	//최근 작성된 후기글 6개를 담아서 보냄
	public List<ReviewDTO> lastReviewBoard(){
		
		List<ReviewDTO> aList = new ArrayList<ReviewDTO>();
		try {
			conn=JdbcTemplate.getConnection();
			String sql = "select a.boardkey, a.title ,a.day from (select * from REVIEWBOARD order by day desc)a where rownum <= 6";
			pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(1, 5);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReviewDTO dto = new ReviewDTO();
				dto.setBoardkey(rs.getString("boardkey"));
				dto.setTitle(rs.getString("title"));
			
				aList.add(dto);
			}
			System.out.println("리뷰 DAO");
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
	}////////////////////최근 후기게시글/////////////////////////////
	
	
	
	
	

}//end DAO//////////////////////////////////////////////////////////////////
