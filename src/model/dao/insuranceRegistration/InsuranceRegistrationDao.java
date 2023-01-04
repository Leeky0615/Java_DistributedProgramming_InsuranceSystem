package model.dao.insuranceRegistration;

import java.util.ArrayList;

import constants.ControlConstants.EInsuranceType;
import model.entity.Customer;
import model.entity.Insurance;
import model.entity.InsuranceDesign;

public interface InsuranceRegistrationDao {
	public void insert(Insurance insuracne);
	public ArrayList<InsuranceDesign> select();
	public void update(Customer customer);
	public Insurance selectByCancerInsurance(int customerId);
	public Insurance selectByFireInsurance(int customerId);
	public Insurance selectByCarInsurance(int customerId);
	public void delete(EInsuranceType eInsuranceType ,int customerId);
}
