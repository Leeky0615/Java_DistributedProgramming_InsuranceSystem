package model.login;

import java.util.ArrayList;

import control.login.Login;

public interface LoginDao {
	public ArrayList<Login> select();
}
