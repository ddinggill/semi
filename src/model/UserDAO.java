package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	//로그인하는 해당 정보가 있으면 true리턴
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
	
	//해당 유저의 정보 리턴
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
	
	}//end class
