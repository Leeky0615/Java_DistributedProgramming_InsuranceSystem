package model.dao.customer;

import java.util.ArrayList;

import model.entity.Customer;

public interface CustomerDao {
	public void insert(Customer customer);

	public ArrayList<Customer> select() ;
}
