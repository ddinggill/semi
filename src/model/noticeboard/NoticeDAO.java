package model.noticeboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import templet.JdbcTemplate;


public class NoticeDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Statement stmt;
	
	private NoticeDAO() {
		
	}
	
	private static NoticeDAO dao = new NoticeDAO();
	
	public static NoticeDAO getInstance() {
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
	
	
	public int rowCount() {
		int row=0;
		try {
			conn = JdbcTemplate.getConnection();
			stmt = conn.createStatement();
			String sql = "select count(*) from noticeboard";
			rs=stmt.executeQuery(sql);
			
			if(rs.next())
				row = rs.getInt(1);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return row;
	}//end rowCount()
	
	public List<NoticeDTO> listMethod(PageDTO pdto){
		List<NoticeDTO> aList = new ArrayList<NoticeDTO>();
		try {
			conn = JdbcTemplate.getConnection();
			String sql = "select b.* from " + 
					"(select rownum as rn ,a.* from " + 
					"(select * from noticeboard " + 
					"order by boardkey  desc)a)b " + 
					"where b.rn>=? and b.rn<=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pdto.getStartRow());
			pstmt.setInt(2, pdto.getEndRow());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				NoticeDTO dto = new NoticeDTO( );
				dto.setUsercode(rs.getInt("usercode"));
				dto.setBoardkey(rs.getInt("boardkey"));
				dto.setTitle(rs.getString("title"));
				dto.setContents(rs.getString("contents"));
				dto.setDay(rs.getDate("day"));
				aList.add(dto);
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
		return aList;
	}//end listMethod()
	
	public void insertMethod(NoticeDTO dto) {
		try {
			conn = JdbcTemplate.getConnection();
			String sql = "insert into notice values(notice_num_seq.nextval,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			//pstmt.setString(2, dto.getContent());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//end insertMethod()
	
	public NoticeDTO oneSelect(int num) {
		NoticeDTO dto = new NoticeDTO();
		try {
			conn = JdbcTemplate.getConnection();
			String sql = "select * from notice where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//dto.setNum(rs.getInt("num"));
				dto.setTitle(rs.getString("title"));
				//dto.setContent(rs.getString("content"));
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
		return dto;
	}//end oneSelect()
	
	public void updateMethod(NoticeDTO dto) {
		try {
			conn = JdbcTemplate.getConnection();
			String sql="update notice set title=?,content=?,today=sysdate where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			//pstmt.setString(2, dto.getContent());
			//pstmt.setInt(3, dto.getNum());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//end updateMethod()
	
	public void deleteMethod(int num){
		try {
			conn = JdbcTemplate.getConnection();
			String sql = "delete from notice where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//end deleteMethod()

}//end class
