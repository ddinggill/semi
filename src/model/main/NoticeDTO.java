package model.main;

import java.sql.Date;

public class NoticeDTO {
	private String boardkey;
	private int usercode;
	private String title;
	private String contents;
	private String isfile;
	private Date day;
	
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
