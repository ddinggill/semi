package model.mypage;

import java.sql.Date;

public class MypageDTO {
	private int usercode;
	private String reviewTitle;
	private Date reviewDate;
	private String comment;
	private String promotionTitle;
	
	
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
	
	
	
	
	
	
	
	
	
	
}//end mypageDTO//////////////////////////////////
