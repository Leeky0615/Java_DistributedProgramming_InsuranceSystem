package model.login;

import java.sql.ResultSet;
import java.util.ArrayList;

import constants.ViewConstants.ELogin;
import control.login.Login;
import model.Dao;

public class LoginDaoImpl extends Dao implements LoginDao{

	@Override
	public ArrayList<Login> select() {
		ArrayList<Login> loginList = new ArrayList<>();
		try {
			String query = "SELECT * FROM login;";
			ResultSet rs = this.select(query);
			while(rs.next()) {
				Login login = new Login();
				switch (rs.getString("userType")) {
				case "customer":login.setLogin(ELogin.customer);break;
				case "salesman":login.setLogin(ELogin.salesman);break;
				case "underwriter":login.setLogin(ELogin.underwriter);break;
				case "developer":login.setLogin(ELogin.developer);break;
				case "assessment":login.setLogin(ELogin.assessment);break;
				default:break;
				}
				login.setId(rs.getString("userId"));
				login.setPassword(rs.getString("password"));
				loginList.add(login);
			}
			rs.close();
		} catch (Exception e) {e.printStackTrace();}
		return loginList;
	}
}
