package model.service.insuranceRegistration;

import java.util.Vector;

import constants.ControlConstants.EInsuranceType;
import model.entity.Customer;
import model.entity.Insurance;
import model.service.customer.CustomerListImpl;
import model.service.insurance.InsuranceListImpl;
import model.service.salesPerson.SalesPersonListImpl;

public interface InsuranceRegistration {
	public Customer getCustomer();
	public void setCustomer(Customer customer);
	public Insurance searchInsurance(int insuranceId);
	public void approve(Customer customer);
	public void disApprove(EInsuranceType eInsuranceType,Customer customer);
	public void request();
	public boolean checkCustomerInfomation(String customerName, String customerId);
	public void writeInsuranceInformation(Insurance insurance, EInsuranceType type, Vector<Object> infos);
	public void associate(InsuranceListImpl insuranceList, CustomerListImpl customerList, SalesPersonListImpl salesPersonList);
}
