package model.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.join.joinDTO;
import templet.JdbcTemplate;

public class AdminDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet rs;
	
	private static AdminDAO dao = new AdminDAO();
	
	private AdminDAO() {
		
	}
	
	public static AdminDAO getInstance() {
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
	}
	
	//update
	public void userlevelUpdate(int usercode, int userlevel) {
		int res=0;
		try {
			conn = JdbcTemplate.getConnection();
			String sql="update member set userlevel=? where usercode=?";		
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userlevel);
			pstmt.setInt(2, usercode);
		
			res= pstmt.executeUpdate();
			//System.out.println(res);
		} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}//end insert()	
	
	public void userdelete(int usercode) {
		try {
			conn = JdbcTemplate.getConnection();
			String sql = "delete from member where usercode=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, usercode);
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
		
	}
	
}//end class
