package model.festival;

import java.util.Date;

/*
 * 후기게시판 관련된 데이터 모델
 * 작성자 : 박종현
 * 작성일 : 2019.08.13
 */
public class ReviewBoardDTO {
			// 후기 작성자코드, 축제코드
	private int usercode, fcode; 
				// 후기글 코드, 후기글 제목, 축제글 제목, 후기 내용, 첨부파일명
	private String boardkey, btitle, ftitle, contents, filename;
			// 글 작성일
	private Date day;
			// 후기 작성자이름
	private String userName;
	
	public ReviewBoardDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getFtitle() {
		return ftitle;
	}

	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}

	public int getUsercode() {
		return usercode;
	}

	public void setUsercode(int usercode) {
		this.usercode = usercode;
	}

	public int getFcode() {
		return fcode;
	}

	public void setFcode(int fcode) {
		this.fcode = fcode;
	}

	public String getBoardkey() {
		return boardkey;
	}

	public void setBoardkey(String boardkey) {
		this.boardkey = boardkey;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
