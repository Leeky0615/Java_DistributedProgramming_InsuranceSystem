package model.customer;

import java.util.ArrayList;
import java.util.List;

import control.customer.Customer;
import model.Dao;

public class CustomerDaoImpl extends Dao implements CustomerDao{
	public CustomerDaoImpl() {super();}
	/*
	 *  super클래스(Dao클래스)에서 선언한 session(인스턴스변수)의 
	 *  함수 selectList()를 사용 -> 테이블에 있는 모든 값을 list에 담음
	 *  selectList()에 있는 파라미터는 mapper.xml파일에서 
	 *  미리 정해둔 Select태그를 이용 -> mapper이름+사용할 태그이름
	 */
	public ArrayList<Customer> select() {
		List<Customer> list = session.selectList("Customer.Select");
		return (ArrayList<Customer>)list;
	}
	
	
//-------------------------------------------------------------------------------------------
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
	
}
