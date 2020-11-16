package model.customer;

import java.util.ArrayList;
import java.util.List;

import control.customer.Customer;
import model.Dao;

public class CustomerDaoImpl extends Dao implements CustomerDao{
	public CustomerDaoImpl() {super();}
	
	public void insert(Customer customer) {
		try {
			StringBuilder sb1 = new StringBuilder();
			sb1.append("INSERT INTO customer (`name`, `customerid`, `gender`, `age`, `phoneNum`, `job`, `illHistory`, `property`, `registrationstatus`) VALUES ('");
			sb1.append(customer.getName()+"', '");
			sb1.append(customer.getCustomerSID()+"', '");
			sb1.append(customer.getGender()+"', '");
			sb1.append(customer.getAge()+"', '");
			sb1.append(customer.getPhoneNum()+"', '");
			sb1.append(customer.getJob()+"', '");
			sb1.append(customer.getillHistory()+"', '");
			sb1.append(customer.getProperty()+"', '");
			sb1.append(0+"');");
			super.insert(sb1.toString());
		} catch (Exception e) {e.printStackTrace();}
	}

	public ArrayList<Customer> select() {
		List<Customer> list = session.selectList("Customer.Select");
		return (ArrayList<Customer>)list;
	}
}
