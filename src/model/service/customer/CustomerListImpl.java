package model.service.customer;

import java.util.ArrayList;

import model.dao.customer.CustomerDao;
import model.dao.customer.CustomerDaoImpl;
import model.dto.Customer;

public class CustomerListImpl implements CustomerList {
	private CustomerDao customerDao;
	private ArrayList<Customer> customerList;
	
	public CustomerListImpl(){
		this.customerDao = new CustomerDaoImpl();
	}

	public ArrayList<Customer> getCustomerList() {return this.customerList = customerDao.select();}

	public boolean add(Customer customer){
		this.customerList.add(customer);
		return true;
	}
	public boolean delete(Customer customer){
		this.customerList.remove(customer);
		return false;
	}
	@SuppressWarnings("unlikely-arg-type")
	public boolean deleteById(String customerId){
		this.customerList.remove(customerId);
		return false;
	}
	public Customer searchByName(String customerName){
		for(Customer customer : this.customerList) {
			if (customer.getName().equals(customerName)) {return customer;}
		}
		return null;
	}
	public Customer searchById(String customerSID){
		for(Customer customer : this.customerList) {
			if (customer.getCustomerSID().equals(customerSID)) {return customer;}
		}
		return null;
	}
}