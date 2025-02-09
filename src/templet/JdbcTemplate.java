package templet;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//db접속 정보
public class JdbcTemplate {

	public JdbcTemplate() {
		
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin://@192.168.30.74:1521:xe";
		String user = "sm2";
		String password = "a1234";
		
		return DriverManager.getConnection(url, user, password);
	}//end getConnection()///////
	
	public static void close(Connection conn) {
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}//end close Connection
	
	public static void close(ResultSet rs) {
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}//end close Resultset
	
	public static void close(Statement stmt) {
		if(stmt!=null)
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}//end close Statement
	
	public static void close(PreparedStatement pstmt) {
		if(pstmt!=null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}//end close PreparedStatement
	
	public static void close(CallableStatement cstmt) {
		if(cstmt!=null)
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}//end close CallableStatement
}//end class
