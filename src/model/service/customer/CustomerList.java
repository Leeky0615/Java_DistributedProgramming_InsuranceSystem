package model.service.customer;

import java.util.ArrayList;

import model.entity.Customer;

public interface CustomerList{
	public boolean add(Customer customer);
	public boolean delete(Customer customer);
	public boolean deleteById(String customerID);
	public Customer searchByName(String customerName);
	public Customer searchById(String customerID);
	public ArrayList<Customer> getCustomerList();
}
