package controller.checkCustomerInfo;

import java.util.Vector;

import model.service.checkCustomerInfo.CheckCustomerInfoImpl;

public class CheckCustomerInfoControllerImpl implements CheckCustomerInfController {
	private CheckCustomerInfoImpl checkCustomerInfo;
	
	public CheckCustomerInfoControllerImpl() {
	}

	public void connectCtoS(CheckCustomerInfoImpl checkCustomerInfo) {
		this.checkCustomerInfo = checkCustomerInfo;
	}

	public void addNewCustomerInformation(Vector<String> customerContents) {
		this.checkCustomerInfo.addNewCustomerInformation(customerContents);
	}
}
