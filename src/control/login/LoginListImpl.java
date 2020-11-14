package control.login;

import java.util.ArrayList;

import model.login.LoginDao;
import model.login.LoginDaoImpl;

public class LoginListImpl implements LoginList{
	private LoginDao loginDao;
	private ArrayList<Login> loginList;

	public LoginListImpl() {
		this.loginDao = new LoginDaoImpl();
		this.loginList = loginDao.select();
	}
	public ArrayList<Login> getLoginList() {return loginList;}
	public void setLoginList(ArrayList<Login> loginList) {this.loginList = loginList;}
}
