package controller.insuranceRegistration;

import java.util.Vector;

import constants.ControlConstants.EInsuranceType;
import model.entity.Customer;
import model.entity.Insurance;
import model.service.insuranceRegistration.InsuranceRegistrationImpl;

public class InsuranceRegistrationControllerImpl implements InsuranceRegistrationController {
	private InsuranceRegistrationImpl insuranceRegistration;

	public InsuranceRegistrationControllerImpl() {}

	public void connectCtoS(InsuranceRegistrationImpl insuranceRegistration) {
		this.insuranceRegistration = insuranceRegistration;
	}

	public void writeInsuranceInformation(Insurance requestInsurance, EInsuranceType type, Vector<Object> infos) {
		this.insuranceRegistration.writeInsuranceInformation(requestInsurance, type, infos);
	}

	public void request() {
		this.insuranceRegistration.request();
	}

	public boolean checkCustomerInfomation(String customerName, String customerId) {
		return this.insuranceRegistration.checkCustomerInfomation(customerName, customerId);
	}


	public Insurance searchInsurance(int insuranceId) {
		return this.insuranceRegistration.searchInsurance(insuranceId);
	}

	public Insurance getReadyInsurance(int id) {
		return this.insuranceRegistration.getReadyInsurance(id);
	}

	public void approve(Customer customer) {
		this.insuranceRegistration.approve(customer);
	}

	public void disApprove(EInsuranceType insuranceType, Customer customer) {
		this.insuranceRegistration.disApprove(insuranceType, customer);
	}

}
