package model.main;

import java.sql.Date;

public class ReviewDTO {

	private String boardkey;
	private int usercode;
	private int fcode;
	private String title;
	private String contents;
	private String isfile;
	private Date day;
	
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
