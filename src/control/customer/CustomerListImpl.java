package control.customer;

import java.util.ArrayList;

import model.customer.CustomerDao;
import model.customer.CustomerDaoImpl;

public class CustomerListImpl implements CustomerList {
	private CustomerDao customerDao;
	private ArrayList<Customer> customerList;
	
	public CustomerListImpl(){
		this.customerDao = new CustomerDaoImpl();
		this.customerList = customerDao.select();
	}

	public ArrayList<Customer> getCustomerList() {return customerList;}
	public void setCustomerList(ArrayList<Customer> customerList) {this.customerList = customerList;}

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
	public Customer searchById(String customerId){
		for(Customer customer : this.customerList) {
			if (customer.getCustomerId().equals(customerId)) {return customer;}
		}
		return null;
	}
}