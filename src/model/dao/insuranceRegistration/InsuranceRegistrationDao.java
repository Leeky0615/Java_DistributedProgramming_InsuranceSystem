package model.dao.insuranceRegistration;

import java.util.ArrayList;

import constants.ControlConstants.EInsuranceType;
import model.service.customer.Customer;
import model.service.insurance.Insurance;
import model.service.insuranceDesign.InsuranceDesign;

public interface InsuranceRegistrationDao {
	public void insert(Insurance insuracne);
	public ArrayList<InsuranceDesign> select();
	public void update(Customer customer);
	public Insurance selectByCancerInsurance(int customerId);
	public Insurance selectByFireInsurance(int customerId);
	public Insurance selectByCarInsurance(int customerId);
	public void delete(EInsuranceType eInsuranceType ,int customerId);
}
