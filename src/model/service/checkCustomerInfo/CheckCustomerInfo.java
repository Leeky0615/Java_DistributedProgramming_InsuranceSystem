package model.service.checkCustomerInfo;

import java.util.Vector;

import model.entity.Customer;
import model.service.customer.CustomerListImpl;

public interface CheckCustomerInfo {
	public void associate(CustomerListImpl customerList);
	public Customer searchCustomerbyId(String customerId);
	public void addNewCustomerInformation(Vector<String> customerContents);
}
