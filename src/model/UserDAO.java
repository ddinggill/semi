package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import templet.JdbcTemplate;

public class UserDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet rs;
	
	private static UserDAO dao = new UserDAO();
	
	private UserDAO() {
		
	}
	
	public static UserDAO getInstance() {
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
	
	public boolean loginCheck(UserDTO dto) {
		boolean chk=false;;
		
		try {
			conn = JdbcTemplate.getConnection();
			String sql = "select * from member"
					+ " where userid=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getUserpw());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				chk = true;
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
		
		return chk;
	}//end loginCheck
	
	public UserDTO userInfo(UserDTO dto) {
		try {
			conn = JdbcTemplate.getConnection();
			String sql = "select * from member where userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setName(rs.getString("name"));
				dto.setNickname(rs.getString("nickname"));
				dto.setPhonenumber(rs.getString("phonenumber"));
				dto.setUsercode(Integer.parseInt(rs.getString("usercode")));
				dto.setUseremail(rs.getString("useremail"));
				dto.setUserlevel(rs.getInt("userlevel"));
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
	}//end userInfo
	
	public List<UserDTO> userAllInfo() {
		
		List<UserDTO> alist = new ArrayList<UserDTO>();
		
		try {
			conn = JdbcTemplate.getConnection();
			String sql = "select * from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				UserDTO dto = new UserDTO();
				dto.setUserid(rs.getString("userid"));
				dto.setName(rs.getString("name"));
				dto.setNickname(rs.getString("nickname"));
				dto.setPhonenumber(rs.getString("phonenumber"));
				dto.setUsercode(Integer.parseInt(rs.getString("usercode")));
				dto.setUseremail(rs.getString("useremail"));
				dto.setUserlevel(rs.getInt("userlevel"));
				
				alist.add(dto);
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
		
		return alist;
	}//end userInfo
}//end class
