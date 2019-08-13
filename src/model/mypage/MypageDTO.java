package model.mypage;

import java.sql.Date;

public class MypageDTO {
	private int usercode;    	//유저의 코드(기본키)
	private String reviewTitle; //후기글 제목
	private String reviewcode;	//후기글 보드키
	private Date reviewDate;	//후기글 작성 날짜
	private String comment;		//댓글
	private String promotionTitle;//홍보문의글 제목
	private String promotioncode;	//홍보문의 글 보드키
	
	
	public MypageDTO() {
		// TODO Auto-generated constructor stub
	}


	public int getUsercode() {
		return usercode;
	}


	public void setUsercode(int usercode) {
		this.usercode = usercode;
	}


	public String getReviewTitle() {
		return reviewTitle;
	}


	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}


	public Date getReviewDate() {
		return reviewDate;
	}


	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public String getPromotionTitle() {
		return promotionTitle;
	}


	public void setPromotionTitle(String promotionTitle) {
		this.promotionTitle = promotionTitle;
	}
	
	public String getReviewcode() {
		return reviewcode;
	}


	public void setReviewcode(String reviewcode) {
		this.reviewcode = reviewcode;
	}


	public String getPromotioncode() {
		return promotioncode;
	}


	public void setPromotioncode(String promotioncode) {
		this.promotioncode = promotioncode;
	}
	
	
	
	
	
	
	
	
}//end mypageDTO//////////////////////////////////
