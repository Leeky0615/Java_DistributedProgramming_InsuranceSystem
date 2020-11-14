package control.insuranceRegistration;

import java.util.Vector;

import constants.ControlConstants.EInsuranceType;
import control.customer.Customer;
import control.customer.CustomerListImpl;
import control.insurance.Insurance;
import control.insurance.InsuranceListImpl;
import control.salesPerson.SalesPersonListImpl;

public interface InsuranceRegistration {
	public Customer getCustomer();
	public void setCustomer(Customer customer);
	public Insurance searchInsurance(int insuranceId);
	public void approve(Customer customer);
	public void disApprove(EInsuranceType eInsuranceType,Customer customer);
	public void request();
	public boolean writeCustomerInfomation(String customerName, String customerId);
	public void writeInsuranceInformation(Insurance insurance, EInsuranceType type, Vector<Object> infos);
	public void associate(InsuranceListImpl insuranceList, CustomerListImpl customerList, SalesPersonListImpl salesPersonList);
}