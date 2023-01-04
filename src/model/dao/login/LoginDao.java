package model.dao.login;

import java.util.ArrayList;

import model.entity.Login;

public interface LoginDao {
	public ArrayList<Login> select();
}
