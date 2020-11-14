package control.login;

import constants.ViewConstants.ELogin;

public class Login {
	private String Id;
	private String password;
	private ELogin login;
	public Login() {}
	
	public String getId() {return Id;}
	public void setId(String id) {Id = id;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public ELogin getLogin() {return login;}
	public void setLogin(ELogin login) {this.login = login;}
	
}
