package model.login;

import java.util.ArrayList;
import java.util.List;

import control.login.Login;
import model.Dao;

public class LoginDaoImpl extends Dao implements LoginDao{
	public LoginDaoImpl() {super();}
	
	public ArrayList<Login> select() {
		List<Login> list = session.selectList("Login.Select");
		return (ArrayList<Login>)list;
	}
}
