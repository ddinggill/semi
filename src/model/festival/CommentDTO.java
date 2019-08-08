package model.festival;

public class CommentDTO {
	
	private String recontents,userName; //댓글 콘텐츠
	private int rekey; //댓글고유키
	private String boardkey;
	private int usercode, fcode;
	
	
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRecontents() {
		return recontents;
	}
	public void setRecontents(String recontents) {
		this.recontents = recontents;
	}
	public int getRekey() {
		return rekey;
	}
	public void setRekey(int rekey) {
		this.rekey = rekey;
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
	
	
	
	
}
