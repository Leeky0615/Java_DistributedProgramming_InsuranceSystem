package controller.customer;

import java.util.ArrayList;

import model.entity.Customer;
import model.service.customer.CustomerListImpl;

public class CustomerControllerImpl implements CustomerController {
	private CustomerListImpl customerList;

	public CustomerControllerImpl() {

	}

	public void connectCtoS(CustomerListImpl customerList) {
		this.customerList = customerList;
	}

	public ArrayList<Customer> getCustomerList() {
		return this.customerList.getCustomerList();
	}
}
