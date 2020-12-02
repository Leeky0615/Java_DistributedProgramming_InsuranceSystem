package model.service.login;

import java.util.ArrayList;

import model.dao.login.LoginDao;
import model.dao.login.LoginDaoImpl;
import model.dto.Login;

public class LoginListImpl implements LoginList{
	private LoginDao loginDao;
	private ArrayList<Login> loginList;

	public LoginListImpl() {
		this.loginDao = new LoginDaoImpl();
	}
	public ArrayList<Login> getLoginList() {return this.loginList = loginDao.select();}
}
