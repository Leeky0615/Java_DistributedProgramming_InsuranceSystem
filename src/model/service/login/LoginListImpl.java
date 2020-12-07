package model.service.login;

import constants.ViewConstants.ELogin;
import model.dao.login.LoginDao;
import model.dao.login.LoginDaoImpl;
import model.dto.Login;

public class LoginListImpl implements LoginList{
	private LoginDao loginDao;

	public LoginListImpl() {
		this.loginDao = new LoginDaoImpl();
	}
	
	@Override
	public ELogin loginCheck(String id,String password) {
		ELogin userType = null;
		for(Login login : loginDao.select()) {
			if (login.getId().equals(id) && login.getPassword().equals(password)) {
				userType = login.getUserType();
			}
		}
		return userType;
	}
}
