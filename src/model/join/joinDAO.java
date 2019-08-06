package model.join;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import templet.JdbcTemplate;

public class joinDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet rs;
	
	private static joinDAO dao = new joinDAO();
	
	private joinDAO() {
		
	}
	
	public static joinDAO getInstance() {
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
	
	//join
	public int insert(joinDTO dto) {
		int cnt =0;
		try {
			conn = JdbcTemplate.getConnection();
			String sql="insert into member values (member_sq.nextval,?,?,?,?,?,1,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getPhonenumber());
			pstmt.setString(3, dto.getPassword());
			pstmt.setString(4, dto.getName());
			pstmt.setString(5, dto.getNickname());
			pstmt.setString(6, dto.getUsermail());
			cnt = pstmt.executeUpdate();
			
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
		return cnt;
	}//end insert()
	

	//패스워드찾기//
	public boolean find(String userid,String useremail) {
		
		boolean result = false;
		String user = "";
		try {
			conn = JdbcTemplate.getConnection();
			String sql="select userid from member where useremail=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, useremail);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
			user = rs.getString("userid");
			if(userid.equals(user)) {
				result = true;
			} else {
				result= false;
			}
			}
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
		
		return result;	
	}//end find)()
	
	public String resetPW(String userid) {
		//새로운 패스워드 생성
		String pw = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 5; i++) {
			sb.append((char) ((Math.random() * 26) + 97));
		}
		pw=sb.toString();
		System.out.println("pw:"+pw);
		
		//새로운 패스워드로 update
		try {
			conn = JdbcTemplate.getConnection();
			String sql = "update member set password=? where userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, userid);
			
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pw;
	}//end resetPW()
	
	public boolean idchk(String userid) {
		boolean chk = true;
		
		try {
			conn = JdbcTemplate.getConnection();
			String sql = "select userid from member where userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				chk = false;
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
	}
	
}//end class
