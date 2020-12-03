package controller.insuranceRegistration;

import java.util.Vector;

import constants.ControlConstants.EInsuranceType;
import model.service.customer.Customer;
import model.service.insurance.Insurance;
import model.service.insuranceRegistration.InsuranceRegistrationImpl;

public interface InsuranceRegistrationController {
	public void connectCtoS(InsuranceRegistrationImpl insuranceRegistration);
	public boolean writeCustomerInfomation(String customerName, String customerId);
	public void writeInsuranceInformation(Insurance requestInsurance, EInsuranceType type, Vector<Object> infos);
	public void request();
	public Insurance searchInsurance(int insuranceId);
	public Insurance getReadyInsurance(int id);
	public void approve(Customer customer);
	public void disApprove(EInsuranceType insuranceType, Customer customer);
}
