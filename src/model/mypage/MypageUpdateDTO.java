package model.mypage;

public class MypageUpdateDTO {

	private int usercode;	//회원의 코드(기본키)
	private String password;
	private String nickname;
	private String name;
	private String email;
	
	public MypageUpdateDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public int getUsercode() {
		return usercode;
	}
	public void setUsercode(int usercode) {
		this.usercode = usercode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
	
	
}//end 
