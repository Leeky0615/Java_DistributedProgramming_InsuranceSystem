package model.dao.login;

import java.util.ArrayList;

import model.service.login.Login;

public interface LoginDao {
	public ArrayList<Login> select();
}
