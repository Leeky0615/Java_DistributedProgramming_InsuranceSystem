package model.customer;

import java.util.ArrayList;

import control.customer.Customer;

public interface CustomerDao {
	public void insert(Customer customer);

	public ArrayList<Customer> select() ;
}
