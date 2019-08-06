package model.promotion;

import java.sql.Date;

public class PromotionCommentDTO {

	private String boardkey;
	private String commentTitle;
	private String commentContents;
	private Date commentday;
	private int commentcode;
	
	public PromotionCommentDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getBoardkey() {
		return boardkey;
	}

	public void setBoardkey(String boardkey) {
		this.boardkey = boardkey;
	}

	public String getCommentTitle() {
		return commentTitle;
	}

	public void setCommentTitle(String commentTitle) {
		this.commentTitle = commentTitle;
	}

	public String getCommentContents() {
		return commentContents;
	}

	public void setCommentContents(String commentContents) {
		this.commentContents = commentContents;
	}

	public Date getCommentday() {
		return commentday;
	}

	public void setCommentday(Date commentday) {
		this.commentday = commentday;
	}

	public int getCommentcode() {
		return commentcode;
	}

	public void setCommentcode(int commentcode) {
		this.commentcode = commentcode;
	}
	
	
	
	
	
}
