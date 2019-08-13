package model.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.UserDTO;
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
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
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
		
	}//end userdelete 
	
	//모든 유저리스트 가져오기
	public List<UserDTO> userAllInfo(PageDTO pdto) {
		
		List<UserDTO> alist = new ArrayList<UserDTO>();
		
		try {
			conn = JdbcTemplate.getConnection();
			String sql = "select b.* from " + 
					"(select rownum as rn ,a.* from " + 
					"(select * from member " + 
					"order by usercode)a)b " + 
					"where b.rn>=? and b.rn<=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pdto.getStartRow());
			pstmt.setInt(2, pdto.getEndRow());
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
	}//end AlluserInfo

	
	public int rowCount() {
		int row=0;
		try {
			conn = JdbcTemplate.getConnection();
			stmt = conn.createStatement();
			String sql = "select count(*) from member";
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

}//end class
