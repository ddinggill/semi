package model.promotion;

import java.sql.Date;

public class PromotionCommentDTO {

	private String boardkey;	//홍보문의글의 보드키(외래키)
	private String commentTitle;	//답변글의 제목
	private String commentContents;	//답변글의 내용
	private Date commentday;		//답변글의 작성일
	private int commentcode;		//답변글의 보드키(기본키)
	
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
