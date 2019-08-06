package model.festival;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


public class FestDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static FestDAO dao = new FestDAO();
	private FestDAO() {
	}

	public static FestDAO getInstance() {
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
	
	// sh add sector start
	
	//조회수 증가 sh add
	public void readCount(int code) {
		try {
			conn = init();
			String sql = "update festival set fview= fview+1 where fcode=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
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
	}//조회수 증가 sh add
	
	
	//내부내용 contents start sh add
	public List<FestDTO> contents(int code){
		List<FestDTO> aList = new ArrayList<FestDTO>();
		try {
			conn = init();
			String sql = "select * from festival where fcode=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				FestDTO dto = new FestDTO();
				dto.setFcode(rs.getInt("fcode"));
				dto.setFtitle(rs.getString("ftitle"));
				dto.setFsdate(rs.getDate("fsdate"));
				dto.setFedate(rs.getDate("fedate"));
				dto.setFimgpath(rs.getString("fimgpath"));
				dto.setFmainpath(rs.getString("fmainpath"));
				dto.setFcontents(rs.getString("fcontents"));
				dto.setFmap(rs.getString("fmap"));
				dto.setFaddress(rs.getString("faddress"));
				dto.setFview(rs.getInt("fview"));
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
	}//contents end sh add
	
	
	//축제등록 start
		public void insertFestival(FestDTO dto,String sdate, String edate) {
			System.out.println(dto.getFcode());
			
			try {
				conn = init();
				String sql = "insert into festival (fcode,ftitle,fsdate,fedate,faddress,fcontents,fimgpath,fmainpath,fview,floc,recommend,fmap)\r\n" + 
						"values(festival_sq.nextval,?,?,?,?,?,?,?,1,1,1,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getFtitle());
				pstmt.setString(2, sdate);
				pstmt.setString(3, edate);
				pstmt.setString(4, dto.getFaddress());
				pstmt.setString(5, dto.getFcontents());
				pstmt.setString(6, dto.getFimgpath());
				pstmt.setString(7, dto.getFmainpath());
				pstmt.setString(8, dto.getFmap());
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
			
		}//축제 등록 end
	
	
	
	
	
	
	
	//sh add sector stop 
	
	
	/*
	 * //조회수 증가 public void readCountMethod(int fcode) { try { conn=init(); String
	 * sql="update festival set fview = fview+1 where fcode=?";
	 * pstmt=conn.prepareStatement(sql); pstmt.setInt(1, fcode);
	 * pstmt.executeUpdate(); } catch (ClassNotFoundException | SQLException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } }// readCountMethod()
	 * /////////////
	 */		
	public List<FestDTO> getFestList(String place, String month) {
		List<FestDTO> list = new ArrayList<FestDTO>();
		System.out.println(place + ","+ month);
		try {
			conn = init();
			String sql = "select * from festival";
			SimpleDateFormat SDF = new SimpleDateFormat("yy-MM-dd"); 
			Calendar CAL = new GregorianCalendar(); 
			String fDate = SDF.format(CAL.getTime());
			int year = (CAL.get( CAL.YEAR ))-2000;
			CAL.set(Calendar.MONTH,Integer.parseInt(month)-1);
			int lastDay = CAL.getActualMaximum(Calendar.DATE);
			String sdate = "";
			String edate = "";
			sdate+= year + "/" + month+"/"+lastDay;
			edate+= year + "/" + month+"/1";
			//System.out.println(sdate + ","+edate);
			
			//if(place.equals("0") && date.equals("0")) {
				//System.out.println("지역 월 모두 0");
			if(!(place.equals("0")) && !(month.equals("0"))) {
				//System.out.println("지역 월 모두 0이 아님");
				sql+=" where (fsdate <= ? and fedate >= ?) and floc = ?";
			}else if(place.equals("0") && !(month.equals("0"))) {
				//System.out.println("지역은 0 월은 0이 아님");
				sql+=" where (fsdate <= ? and fedate >= ?)";
				
			}else if(!(place.equals("0")) && month.equals("0")) {
				//System.out.println("지역은 0이 아니고 월은 0임");
				sql+=" where floc = ?";
			}
			
			pstmt=conn.prepareStatement(sql);
			
			if(!(place.equals("0")) && !(month.equals("0"))) {
				//System.out.println("지역 월 모두 0이 아님");
				pstmt.setString(1, sdate);
				pstmt.setString(2, edate);
				pstmt.setString(3, place);
			}else if(place.equals("0") && !(month.equals("0"))) {
				//System.out.println("지역은 0 월은 0이 아님");
				pstmt.setString(1, sdate);
				pstmt.setString(2, edate);
			}else if(!(place.equals("0")) && month.equals("0")) {
				//System.out.println("지역은 0이 아니고 월은 0임");
				pstmt.setString(1, place);
			}
			System.out.println(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FestDTO dto = new FestDTO();
				dto.setFcode(rs.getInt("fcode"));
				dto.setFsdate(rs.getDate("fsdate"));
				dto.setFedate(rs.getDate("fedate"));
				dto.setFtitle(rs.getString("ftitle"));
				dto.setFimgpath(rs.getString("fimgpath"));
				//System.out.println(dto.getFcode()+","+dto.getFsdate()+","+dto.getFedate()+","+dto.getFtitle()+","+dto.getFimgpath());
				list.add(dto);
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

		return list;
	}// end getFestList()//////////////////////
	
	public List<FestDTO> getHotList() {
		List<FestDTO> list = new ArrayList<FestDTO>();
		try {
			int view_num = 10;
			conn = init();
			String sql = "select * from(select rownum rnum, a.* from (select * from festival order by fview desc) a) b where rnum<=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, view_num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FestDTO dto = new FestDTO();
				dto.setFcode(rs.getInt("fcode"));
				dto.setFsdate(rs.getDate("fsdate"));
				dto.setFedate(rs.getDate("fedate"));
				dto.setFtitle(rs.getString("ftitle"));
				dto.setFimgpath(rs.getString("fimgpath"));
				list.add(dto);
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

		return list;
	}// end getFestList()//////////////////////
	
	public FestDTO getFestView(int fcode) {
		FestDTO dto = null;
		
		try {
			conn = init();
			String sql = "select * from festival where fcode=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fcode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new FestDTO();
				dto.setFcode(rs.getInt("fcode"));
				dto.setFsdate(rs.getDate("fsdate"));
				dto.setFedate(rs.getDate("fedate"));
				dto.setFtitle(rs.getString("ftitle"));
				dto.setFimgpath(rs.getString("fimgpath"));
				
				dto.setFmainpath(rs.getString("fmainpath"));
				dto.setFaddress(rs.getString("faddress"));
				dto.setFcontents(rs.getString("fcontents"));
				dto.setFview(rs.getInt("fview"));
				dto.setFloc(rs.getInt("floc"));
				dto.setRecommend(rs.getInt("recommend"));
				//System.out.println(dto.getFcode()+","+dto.getFsdate()+","+dto.getFedate()+","+dto.getFtitle()+","+dto.getFimgpath());
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
	}// end getFestView()//////////////////////
	
	public List<ReviewBoardDTO> getReview(int fcode) {

		List<ReviewBoardDTO> aList = new ArrayList<ReviewBoardDTO>();
				try {
					conn = init();
					String sql = "select r.*,m.NAME from reviewboard r, member m where r.USERCODE = m.USERCODE and fcode=2 order by day desc";
					pstmt=conn.prepareStatement(sql);
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
	}// end getReview()//////////////////////
}
