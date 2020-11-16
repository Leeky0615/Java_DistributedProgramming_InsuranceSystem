package model.insuranceRegistration;

import java.util.ArrayList;

import constants.ControlConstants.EInsuranceType;
import control.customer.Customer;
import control.insurance.Insurance;
import control.insuranceDevelopment.InsuranceDesign;

public interface InsuranceRegistrationDao {
	public void insert(Customer customer, Insurance insuracne);
	public ArrayList<InsuranceDesign> select();
	public void update(boolean status ,int customerId);
	public Insurance selectByCancerInsurance(int customerId);
	public Insurance selectByFireInsurance(int customerId);
	public Insurance selectByCarInsurance(int customerId);
	public void delete(EInsuranceType eInsuranceType ,int customerId);
}
