package model.festival;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class ReviewBoardDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static ReviewBoardDAO dao=new ReviewBoardDAO();
	private ReviewBoardDAO() {}
	public static ReviewBoardDAO getInstance() {
		return dao;
	}

	private Connection init() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin://@192.168.30.74:1521:xe";
		String user = "SM2";
		String password = "a1234";
		return DriverManager.getConnection(url, user, password);
	}// end init()

	private void exit() throws SQLException {
		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
	}// end exit()


	// sh add start
	
	
	//선택값만보기
		public List<ReviewBoardDTO> ReviewSel(int key){
			List<ReviewBoardDTO> aList = new ArrayList<ReviewBoardDTO>();
			try {
				conn=init();
				String sql = "select ft.fcode fcode,rw.boardkey rkey, mb.usercode ucd,rw.title rtitle,rw.day rday,\r\n" + 
						"ft.ftitle ftitle,mb.name Nm,rw.FILENAME attach,rw.contents contents\r\n" + 
						"from reviewboard rw, festival ft, member mb\r\n" + 
						"where rw.FCODE = ft.fcode\r\n" + 
						"and rw.usercode = mb.usercode\r\n" + 
						"and ft.fcode=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, key);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
				ReviewBoardDTO dto = new ReviewBoardDTO();
				dto.setFcode(rs.getInt("fcode"));
				dto.setBoardkey(rs.getString("rkey"));
				dto.setUsercode(rs.getInt("ucd"));
				dto.setUserName(rs.getString("Nm"));
				dto.setFtitle(rs.getString("ftitle"));
				dto.setBtitle(rs.getString("rtitle"));
				dto.setDay(rs.getDate("rday"));
				dto.setFilename(rs.getString("attach"));
				dto.setContents(rs.getString("contents"));
				aList.add(dto);
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
		}
	
	// sh add end
	

	public int rowTotalCount(HashMap<String, String> map) {
		int cnt = 0;
		try {
			conn=init();
			String sql = "select count(*) from reviewboard ";
			if (map.get("searchKey") != null) {
				String data = map.get("searchKey");
				if (data.equals("subject") || data.equals("content") || data.equals("writer")) {

					// System.out.println("searchKey");

					if (map.get("searchKey").equals("subject")) {
						sql += " where lower(subject) like ?";
					} else if (map.get("searchKey").equals("content")) {
						sql += " where lower(content) like ?";
					} else if (map.get("searchKey").equals("writer")) {
						sql += " where lower(writer) like ?";
					}
				}
			}
			pstmt=conn.prepareStatement(sql);
			if( map.get("searchKey") != null) {
				String data = map.get("searchKey");
				if(data.equals("subject") || data.equals("content") || data.equals("writer")){
					pstmt.setString(1, "%"+map.get("searchWord").toLowerCase()+"%");
				}
			}

			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("cnt="+cnt);
		return cnt;
	}// end rowTotalCount() /////////////

	public List<ReviewBoardDTO> listMethod(PageDTO pdto){

		List<ReviewBoardDTO> aList = new ArrayList<ReviewBoardDTO>();
		try {
			conn = init();
			String sql = "select b.* ";
			sql+= "from (select rownum as rm, a.* ";
			sql+= "from (select r.*,m.NAME from reviewboard r, member m where r.USERCODE = m.USERCODE ";
			//select r.*,m.NAME from reviewboard r, member m where r.USERCODE = m.USERCODE
			if(pdto.getSearchKey() != null) {
				String data = pdto.getSearchKey();
				if(data.equals("title") || data.equals("contents") || data.equals("userName")){
					if(data.equals("userName"))
						sql+=" and name like lower('%" +pdto.getSearchWord() + "%') ";
					else 
						sql+=" and lower("+ pdto.getSearchKey()+") like lower('%" +pdto.getSearchWord() + "%') ";
				}
			}
			sql += " order by day desc)a)b ";
			sql+= "where b.rm >= ? and b.rm <= ? ";

			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, pdto.getStartRow());
			pstmt.setInt(2, pdto.getEndRow());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ReviewBoardDTO dto = new ReviewBoardDTO();
				
				dto.setBoardkey(rs.getString("boardkey")); //게시글 번호
				dto.setBtitle(rs.getString("title")); //게시글 제목
				dto.setUserName(rs.getString("name")); //게시글 작성자
				dto.setDay(rs.getDate("day")); //게시글 작성일
				dto.setFilename(rs.getString("filename")); //게시글 첨부파일
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
	}//////// end listMethod() ////////////////////////////

	//게시판 뷰 페이지 정보 로딩
	public ReviewBoardDTO viewMethod(String boardkey) {
		ReviewBoardDTO dto=null;
		try {
			conn = init();
			String sql = "select * from reviewboard r, member m where r.usercode=m.usercode and boardkey=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardkey);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new ReviewBoardDTO();
				dto.setUsercode(rs.getInt("usercode"));
				dto.setFcode(rs.getInt("fcode"));
				dto.setBoardkey(rs.getString("boardkey"));
				dto.setBtitle(rs.getString("title"));
				dto.setContents(rs.getString("contents"));
				dto.setFilename(rs.getString("filename"));
				dto.setUserName(rs.getString("name"));
				dto.setDay(rs.getDate("day"));
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
	}//////// end viewMethod() ////////////////////////////

	//글생성
	public void insertMethod(ReviewBoardDTO dto) {
		try {
			conn = init();
			String sql = "insert into reviewboard (boardkey, usercode, fcode, title, contents, filename, day) values (('r'||(review_sq.nextval)),?,?,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getUsercode());
			pstmt.setInt(2, dto.getFcode());
			pstmt.setString(3, dto.getBtitle());
			pstmt.setString(4, dto.getContents());
			pstmt.setString(5, dto.getFilename());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}//////// end insertMethod() ////////////////////////////

	//업로드한 파일 가져오기
	public String fileMethod(String boardkey) {
		String fileName = null;

		try {
			conn=init();
			String sql= "select filename from reviewboard where boardkey=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardkey);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				fileName = rs.getString("filename");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return fileName;
	}//end fileMethod()//////////////////////////////////

	//수정할 뷰 페이지 정보 가져오기
	public ReviewBoardDTO oneSelect(String boardkey) {
		ReviewBoardDTO dto = new ReviewBoardDTO();
		try {
			conn=init();
			String sql= "select * from reviewboard r, member m where r.usercode=m.usercode and boardkey = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardkey);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setBoardkey(rs.getString("boardkey"));
				dto.setUserName(rs.getString("name"));
				dto.setBtitle(rs.getString("title"));
				dto.setDay(rs.getDate("day"));
				dto.setContents(rs.getString("contents"));
				dto.setFilename(rs.getString("filename"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}//end oneSelect() ///////////////////

	//수정 메소드 
	public void updateMethod(ReviewBoardDTO dto) {

		try {
			conn=init();
			String sql = "update reviewboard set title =? , contents = ? , filename = ? where boardkey = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBtitle());
			pstmt.setString(2, dto.getContents());
			pstmt.setString(3, dto.getFilename());
			pstmt.setString(4, dto.getBoardkey());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}//end updateMethod()/////////////////////////////////////////////

	public void deleteMethod(String boardkey) {
		try {
			conn=init();
			String sql = "delete from reviewboard where boardkey = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardkey);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				exit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//end deleteMethod///////////////////////////////
}
