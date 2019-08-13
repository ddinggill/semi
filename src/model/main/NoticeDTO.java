package model.main;

import java.sql.Date;

public class NoticeDTO {
	private String boardkey; //글의 보드키(기본키)
	private int usercode;	//작성한 유저의 코드(외래키)
	private String title; 	//글의 제목
	private String contents; //글의 내용
	private String isfile; //글의 첨부파일
	private Date day;	//글의 작성일자
	
	public NoticeDTO() {
	}

	public String getBoardkey() {
		return boardkey;
	}

	public void setBoardkey(String boardkey) {
		this.boardkey = boardkey;
	}

	public int getUsercode() {
		return usercode;
	}

	public void setUsercode(int usercode) {
		this.usercode = usercode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getIsfile() {
		return isfile;
	}

	public void setIsfile(String isfile) {
		this.isfile = isfile;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}
	
	
	
	
	

}
