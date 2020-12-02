package controller.login;

import constants.ViewConstants.ELogin;
import model.service.checkCustomerInfo.CheckCustomerInfoImpl;
import model.service.login.LoginList;
import model.service.login.LoginListImpl;

public class LoginControllerImpl implements LoginController {
	private LoginList loginList;
	
	public LoginControllerImpl() {
		
	}
	public void connectCtoS(LoginListImpl loginlist) {
		this.loginList = loginlist;
	}
	// Service에 LoginCheck함수를 요청.
	public ELogin loginCheck(String id,String password) {
		return this.loginList.loginCheck(id,password);
	}

}
