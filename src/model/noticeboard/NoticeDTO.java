package model.noticeboard;

import java.util.Date;

public class NoticeDTO {

	private int boardkey;
	private int usercode;
	private String title;
	private String contents;
	private Date day;
	
	
	public int getBoardkey() {
		return boardkey;
	}
	public void setBoardkey(int boardkey) {
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
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	
	
}
