package springmvc.model;

public class User {

	private String email;
	private String userName;
	private String userPass;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


//	public User(String email, String userName, String userPass) {
//		super();
//		this.email = email;
//		this.userName = userName;
//		this.userPass = userPass;
//	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserPass() {
		return userPass;
	}


	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}


	@Override
	public String toString() {
		return "User [email=" + email + ", userName=" + userName + ", userPass=" + userPass + "]";
	}
	
	
}
