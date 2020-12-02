package controller.customer;

import model.service.customer.CustomerListImpl;

public class CustomerControllerImpl implements CustomerController {
	private CustomerListImpl customerList;

	public CustomerControllerImpl() {
		
	}

	public void connectCtoS(CustomerListImpl customerList) {
		this.customerList = customerList;
	}
}
