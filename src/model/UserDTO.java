package model;

public class UserDTO {
	private String userid;
	private String userpw;
	private int usercode;
	private String phonenumber;
	private String name;
	private String nickname;
	private int userlevel;
	private String useremail;
	
	public UserDTO() {
	}

	
	public int getUsercode() {
		return usercode;
	}


	public void setUsercode(int usercode) {
		this.usercode = usercode;
	}


	public String getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public int getUserlevel() {
		return userlevel;
	}


	public void setUserlevel(int userlevel) {
		this.userlevel = userlevel;
	}


	public String getUseremail() {
		return useremail;
	}


	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}


	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	
	
}
