package control.login;

import constants.ViewConstants.ELogin;

public class Login {
	private String userId;
	private String password;
	private ELogin userType;
	
	public Login() {}
	
	public String getId() {return userId;}
	public void setId(String userId) {this.userId = userId;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public ELogin getLogin() {return userType;}
	public void setLogin(ELogin userType) {this.userType = userType;}
}
