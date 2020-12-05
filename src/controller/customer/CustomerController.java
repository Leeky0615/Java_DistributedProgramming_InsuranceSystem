package controller.customer;

import java.util.ArrayList;

import model.dto.Customer;
import model.service.customer.CustomerListImpl;

public interface CustomerController {
	public void connectCtoS(CustomerListImpl customerList);
	public ArrayList<Customer> getCustomerList();
}
