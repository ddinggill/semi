package model.promotion;

import java.sql.Date;
import java.util.List;

public class PromotionDTO {
	
	private String boardkey;	//홍보문의 글의 보드키(기본키)
	private int usercode;		//홍보문의글을 작성한 사용자의 코드
	private String fTitle;		//축제의 제목
	private Date fSdate;		//축제시작일
	private Date fEdate;		//축제 종료일
	private String fAddress;	//축제의 주소
	private String fContents;	//축제의 내용
	private String fImgpath; 	//축제 첨부이미지
	private String fMainpath;	//축제 메인이미지
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
