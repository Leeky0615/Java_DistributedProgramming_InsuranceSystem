package controller.checkCustomerInfo;

import java.util.Vector;

import model.service.checkCustomerInfo.CheckCustomerInfoImpl;

public interface CheckCustomerInfController {
	public void connectCtoS(CheckCustomerInfoImpl checkCustomerInfo);
	public void addNewCustomerInformation(Vector<String> customerContents);
}
