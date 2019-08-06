package model.promotion;

import java.sql.Date;
import java.util.List;

public class PromotionDTO {
	
	private String boardkey;
	private int usercode;
	private String fTitle;
	private Date fSdate;
	private Date fEdate;
	private String fAddress;
	private String fContents;
	private String fImgpath;
	private String fMainpath;
	private List<PromotionCommentDTO> comment;
	public PromotionDTO() {
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

	public String getfTitle() {
		return fTitle;
	}

	public void setfTitle(String fTitle) {
		this.fTitle = fTitle;
	}

	public Date getfSdate() {
		return fSdate;
	}

	public void setfSdate(Date fSdate) {
		this.fSdate = fSdate;
	}

	public Date getfEdate() {
		return fEdate;
	}

	public void setfEdate(Date fEdate) {
		this.fEdate = fEdate;
	}

	public String getfAddress() {
		return fAddress;
	}

	public void setfAddress(String fAddress) {
		this.fAddress = fAddress;
	}

	public String getfContents() {
		return fContents;
	}

	public void setfContents(String fContents) {
		this.fContents = fContents;
	}

	public String getfImgpath() {
		return fImgpath;
	}

	public void setfImgpath(String fImgpath) {
		this.fImgpath = fImgpath;
	}

	public String getfMainpath() {
		return fMainpath;
	}

	public void setfMainpath(String fMainpath) {
		this.fMainpath = fMainpath;
	}

	public List<PromotionCommentDTO> getComment() {
		return comment;
	}

	public void setComment(List<PromotionCommentDTO> comment) {
		this.comment = comment;
	}
	
	
	

}//end DTO
