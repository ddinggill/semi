package model.main;

import java.sql.Date;

public class ReviewDTO {

	private String boardkey; //글의 보드키(기본키)
	private int usercode;	//작성한 유저의 코드(외래키)
	private int fcode;		//작성한 후기의 축제 코드(외래키)
	private String title;	//후기글의 제목
	private String contents;//후기글의 내용
	private String isfile;	//후기글의 첨부파일
	private Date day;		//후기글의 작성일자
	
	public ReviewDTO() {
		// TODO Auto-generated constructor stub
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
	public int getFcode() {
		return fcode;
	}
	public void setFcode(int fcode) {
		this.fcode = fcode;
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
