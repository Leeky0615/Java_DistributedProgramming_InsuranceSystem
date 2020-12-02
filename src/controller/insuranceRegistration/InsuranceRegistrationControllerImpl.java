package controller.insuranceRegistration;

import java.util.Vector;

import constants.ControlConstants.EInsuranceType;
import model.dto.Insurance;
import model.service.insuranceRegistration.InsuranceRegistrationImpl;

public class InsuranceRegistrationControllerImpl implements InsuranceRegistrationController {
	private InsuranceRegistrationImpl insuranceRegistration;
	
	public InsuranceRegistrationControllerImpl() {
		
	}
	
	public void connectCtoS(InsuranceRegistrationImpl insuranceRegistration) {
		this.insuranceRegistration = insuranceRegistration;
	}

	public boolean writeCustomerInfomation(String customerName, String customerId) {
		return this.insuranceRegistration.writeCustomerInfomation(customerName, customerId);
	}

	public void writeInsuranceInformation(Insurance requestInsurance, EInsuranceType type, Vector<Object> infos) {
		this.insuranceRegistration.writeInsuranceInformation(requestInsurance, type, infos);
	}

	public void request() {
		this.insuranceRegistration.request();
	}

}
