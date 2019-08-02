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
					"order by day desc)a)b " + 
					"where b.rn>=? and b.rn<=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pdto.getStartRow());
			pstmt.setInt(2, pdto.getEndRow());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				NoticeDTO dto = new NoticeDTO( );
				dto.setUsercode(rs.getInt("usercode"));
				dto.setBoardkey(rs.getString("boardkey"));
				dto.setTitle(rs.getString("title"));
				dto.setContents(rs.getString("contents"));
				dto.setDay(rs.getDate("day"));
				dto.setFilename(rs.getString("filename"));
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
			String sql = "insert into noticeboard values('n'||notice_sq.nextval,?,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			//유저코드,타이틀,컨텐츠,filename
			pstmt.setInt(1, dto.getUsercode());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContents());
			pstmt.setString(4, dto.getFilename());
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
	
	public NoticeDTO viewMethod(String boardkey) {
		NoticeDTO dto = new NoticeDTO();
		try {
			conn = JdbcTemplate.getConnection();
			String sql = "select * from noticeboard where boardkey=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardkey);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setBoardkey(rs.getString("boardkey"));
				dto.setContents(rs.getString("contents"));
				dto.setDay(rs.getDate("day"));
				dto.setFilename(rs.getString("filename"));
				dto.setTitle(rs.getString("title"));
				dto.setUsercode(rs.getInt("usercode"));
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
	}//end viewMethod();
	
	
	public String fileMethod(String boardkey) {
		String fileName = null;
		
		try {
			conn = JdbcTemplate.getConnection();
			String sql = "select filename from noticeboard where boardkey=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardkey);
			rs = pstmt.executeQuery();
			if(rs.next())
				fileName = rs.getString("filename");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return fileName;
	}//end fileMethod()
	
	public void updateMethod(NoticeDTO dto) {
		try {
			conn = JdbcTemplate.getConnection();
			String sql="update noticeboard set title=?,contents=?,filename=?,day=sysdate where boardkey=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContents());
			pstmt.setString(3, dto.getFilename());
			pstmt.setString(4, dto.getBoardkey());
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
	
	public void deleteMethod(String boardkey){
		try {
			conn = JdbcTemplate.getConnection();
			String sql = "delete from noticeboard where boardkey=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardkey);
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
