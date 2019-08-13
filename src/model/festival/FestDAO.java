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

/*
 * 축제에 관련된 데이터에 접근하여 처리하는 모델
 * 작성자 : 박종현
 * 작성일 : 2019.08.13
 */
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
	
	//조회수 증가 시작
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
	}//조회수 증가 끝
	
	
	//축제 내부내용 contents start 
	public FestDTO contents(int code){
		
		FestDTO dto = null;
		try {
			conn = init();
			String sql = "select * from festival where fcode=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new FestDTO();
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
		
		return dto;
	}//축제 내부내용 contents end
	
	
	//축제등록 start
		public void insertFestival(FestDTO dto,String sdate, String edate) {
			System.out.println(dto.getFcode());
			
			try {
				conn = init();
				String sql = "insert into festival (fcode,ftitle,fsdate,fedate,faddress,fcontents,fimgpath,fmainpath,fview,floc,recommend,fmap)\r\n" + 
						"values(festival_sq.nextval,?,?,?,?,?,?,?,1,?,1,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getFtitle());
				pstmt.setString(2, sdate);
				pstmt.setString(3, edate);
				pstmt.setString(4, dto.getFaddress());
				pstmt.setString(5, dto.getFcontents());
				pstmt.setString(6, dto.getFimgpath());
				pstmt.setString(7, dto.getFmainpath());
				pstmt.setInt(8, dto.getFloc());
				pstmt.setString(9, dto.getFmap());
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
	
	// 축제의 축제명, 축제이미지, 축제기간을 리스트로 출력

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
			
			//축제 검색 지역과 기간이 모두 전체가 아닐때
			if(!(place.equals("0")) && !(month.equals("0"))) {
				sql+=" where (fsdate <= ? and fedate >= ?) and floc = ?";
				
			// 축제 검색 지역은 전체이고 기간은 전체가 아닐때
			}else if(place.equals("0") && !(month.equals("0"))) {
				sql+=" where (fsdate <= ? and fedate >= ?)";
				
			// 축제 검색 지역은 전체가 아니고 기간은 전체일때
			}else if(!(place.equals("0")) && month.equals("0")) {
				sql+=" where floc = ?";
			}
			
			pstmt=conn.prepareStatement(sql);
			
			//축제 검색 지역과 기간이 모두 전체가 아닐때
			if(!(place.equals("0")) && !(month.equals("0"))) {
				pstmt.setString(1, sdate);
				pstmt.setString(2, edate);
				pstmt.setString(3, place);
			
			// 축제 검색 지역은 전체이고 기간은 전체가 아닐때
			}else if(place.equals("0") && !(month.equals("0"))) {
				pstmt.setString(1, sdate);
				pstmt.setString(2, edate);
				
			// 축제 검색 지역은 전체가 아니고 기간은 전체일때
			}else if(!(place.equals("0")) && month.equals("0")) {
				pstmt.setString(1, place);
			}
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FestDTO dto = new FestDTO();
				dto.setFcode(rs.getInt("fcode")); //축제코드
				dto.setFsdate(rs.getDate("fsdate")); //축제 시작일
				dto.setFedate(rs.getDate("fedate")); //축제 종료일
				dto.setFtitle(rs.getString("ftitle")); //축제명
				dto.setFimgpath(rs.getString("fimgpath")); //축제이미지경로
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

	}// end getFestList() add pjh
	
	// 조회수가 가장 많은 상위의 9개 인기 축제의 축제명, 축제이미지, 축제기간을 리스트로 출력

	public List<FestDTO> getHotList() {
		List<FestDTO> list = new ArrayList<FestDTO>();
		try {
			int view_num = 9;
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

	}// end getFestList() add pjh
	
	// 축제의 상세 내용을 출력

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
				
				dto.setFmainpath(rs.getString("fmainpath")); //축제 내용에 들어가는 메인 이미지
				dto.setFaddress(rs.getString("faddress")); // 축제 주소
				dto.setFcontents(rs.getString("fcontents")); // 축제 내용
				dto.setFview(rs.getInt("fview")); //축제글 조회수
				dto.setFloc(rs.getInt("floc")); //축제 지역코드
				dto.setRecommend(rs.getInt("recommend")); // 축제의 추천코드
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

	}// end getFestView() add pjh

}
