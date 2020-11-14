package control.checkCustomerInfo;

import java.util.Vector;

import control.customer.Customer;
import control.customer.CustomerListImpl;

public interface CheckCustomerInfo {
	public void associate(CustomerListImpl customerList);
	public Customer searchCustomerbyId(String customerId);
	public void addNewCustomerInformation(Vector<String> customerContents);
}
