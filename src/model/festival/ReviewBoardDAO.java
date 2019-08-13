package model.festival;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * 축제에 관련된 데이터에 접근하여 처리하는 모델
 * 작성자 : 박종현
 * 작성일 : 2019.08.13
 */
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

	//오라클 DB 접속
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
	
	// 현재 보여지는 모든 레코드 수를 계산
	public int rowTotalCount(HashMap<String, String> map) {
		int cnt = 0;
		try {
			conn=init();
			String sql = "select count(*) from(select r.*,m.NAME from reviewboard r, member m where r.USERCODE = m.USERCODE)a ";
			if (map.get("searchKey") != null) {
				String data = map.get("searchKey");
				if (data.equals("title") || data.equals("contents") || data.equals("userName")) {
					//검색 속성값이 제목일때
					if (map.get("searchKey").equals("title")) {
						sql += " where lower(title) like ?";
					//검색 속성값이 내용일때
					} else if (map.get("searchKey").equals("contents")) {
						sql += " where lower(contents) like ?";
					//검색 속성값이 작성자일때
					} else if (map.get("searchKey").equals("userName")) {
						sql += " where lower(name) like ?";
					}
				}
			}
			pstmt=conn.prepareStatement(sql);
			if( map.get("searchKey") != null) {
				String data = map.get("searchKey");
				//검색 속성값이 제목 or 내용 or 작성자 일때 검색어와 일치하는 결과를 찾음
				if(data.equals("title") || data.equals("contents") || data.equals("userName")){
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
		
		return cnt;
	}// end rowTotalCount() add pjh

	// 후기글을 검색 조건에 맞게 검색하여 한 페이지에 5개씩 최신글부터 순서대로 출력
	public List<ReviewBoardDTO> listMethod(PageDTO pdto){

		List<ReviewBoardDTO> aList = new ArrayList<ReviewBoardDTO>();
		try {
			conn = init();
			String sql = "select b.* ";
			sql+= "from (select rownum as rm, a.* ";
			sql+= "from (select r.*,m.NAME from reviewboard r, member m where r.USERCODE = m.USERCODE ";
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
	}// end listMethod() add pjh

	//후기게시판 상세내용 출력
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
				dto.setUsercode(rs.getInt("usercode")); // 작성자 코드
				dto.setFcode(rs.getInt("fcode")); //축제 코드
				dto.setBoardkey(rs.getString("boardkey")); //게시글 코드
				dto.setBtitle(rs.getString("title")); // 게시글 제목
				dto.setContents(rs.getString("contents")); // 게시글 내용
				dto.setFilename(rs.getString("filename")); // 첨부파일명
				dto.setUserName(rs.getString("name")); // 게시글 작성자
				dto.setDay(rs.getDate("day")); // 게시글 작성일
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
	}// end viewMethod() add pjh

	//후기글 작성
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
	}// end insertMethod() add pjh

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
	}//end fileMethod() add pjh

	//수정할 후기글 정보 가져오기
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
	}//end oneSelect() add pjh

	//후기글 수정 메소드
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

	}//end updateMethod() add pjh

	//후기글 삭제
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
	}//end deleteMethod add pjh
	
	//원글삭제시 댓글도 삭제
	   public void recommendDelAll(String key){
	      
	      try {
	         conn = init();
	         String sql ="delete from f_recomment where boardkey=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, key);
	         pstmt.executeUpdate();
	      } catch (SQLException | ClassNotFoundException e) {
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
	   
	   }//원글삭제시 댓글도 삭제  end
	   
	//insert recommend start
		public void recommendInsert(CommentDTO dto) {
						
			try {
				conn = init();
				String sql = "insert into f_recomment values(f_recomment_sq.nextval,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getBoardkey());
				pstmt.setInt(2, dto.getUsercode());
				pstmt.setInt(3, dto.getFcode());
				pstmt.setString(4, dto.getRecontents());
				pstmt.executeUpdate();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
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
			
		}//insert recommend end
		
		//recommend List start
			public List<CommentDTO> recommendList(String key) {
				List<CommentDTO> aList = new ArrayList<CommentDTO>();
				try {
					conn = init();
					String sql = "select ft.fcontents con, mb.name nm,ft.commentcode rkey,ft.usercode usercode \r\n" + 
							"from f_recomment ft,member mb \r\n" + 
							"where ft.usercode = mb.usercode and boardkey=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, key);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						CommentDTO dto = new CommentDTO();
						dto.setRecontents(rs.getString("con"));
						dto.setUserName(rs.getString("nm"));
						dto.setRekey(rs.getInt("rkey"));
						dto.setUsercode(rs.getInt("usercode"));
						aList.add(dto);
						
					}
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
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
			}//recommend List end
			
			
			public void recommendDel(int key) {
				try {
					conn = init();
					String sql = "delete from f_recomment where commentcode = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, key);
					pstmt.executeUpdate();
					} catch (SQLException | ClassNotFoundException e) {

					e.printStackTrace();
				}finally {
					try {
						exit();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} 
			}//recoomend del end
			
			
			public void recommendUpdate(int key, String con) {
				
				try {
					conn = init();
					String sql="update f_recomment set fcontents= ? where commentcode = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, con);
					pstmt.setInt(2, key);
					pstmt.executeUpdate();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}//recoomend update end

}
