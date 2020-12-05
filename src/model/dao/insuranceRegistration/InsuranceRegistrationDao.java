package model.dao.insuranceRegistration;

import java.util.ArrayList;

import constants.ControlConstants.EInsuranceType;
import model.dto.Customer;
import model.dto.Insurance;
import model.dto.InsuranceDesign;

public interface InsuranceRegistrationDao {
	public void insert(Insurance insuracne);
	public ArrayList<InsuranceDesign> select();
	public void update(Customer customer);
	public Insurance selectByCancerInsurance(int customerId);
	public Insurance selectByFireInsurance(int customerId);
	public Insurance selectByCarInsurance(int customerId);
	public void delete(EInsuranceType eInsuranceType ,int customerId);
}
