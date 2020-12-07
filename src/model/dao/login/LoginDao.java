package model.dao.login;

import java.util.ArrayList;

import model.dto.Login;

public interface LoginDao {
	public ArrayList<Login> select();
}
