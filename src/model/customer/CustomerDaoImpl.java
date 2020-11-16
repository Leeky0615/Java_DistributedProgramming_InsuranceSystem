package model.customer;

import java.sql.ResultSet;
import java.util.ArrayList;

import constants.ControlConstants.EIllHistory;
import constants.ControlConstants.EJob;
import control.customer.Customer;
import model.Dao;

public class CustomerDaoImpl extends Dao implements CustomerDao{
	public CustomerDaoImpl() {
		super();
	}
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
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		try {
			String query = "SELECT * FROM customer;";
			ResultSet rs = this.select(query);
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				customer.setCustomerSID(rs.getString("customerSID"));
				customer.setGender(rs.getBoolean("gender"));
				customer.setAge(rs.getInt("age"));
				customer.setPhoneNum(rs.getString("phoneNum"));
				customer.setRegistrationStatus(rs.getBoolean("registrationStatus"));
				switch (rs.getString("job")) {
				case "SOLDIER":customer.setJob(EJob.SOLDIER);break; 
				case "POLICE":customer.setJob(EJob.POLICE);break; 
				case "FIREMAN":customer.setJob(EJob.FIREMAN);break; 
				case "DRIVER":customer.setJob(EJob.DRIVER);break; 
				case "NO_JOB":customer.setJob(EJob.NO_JOB);break; 
				default:break;
				}
				switch (rs.getString("illHistory")) {
				case "NOTHING":customer.setillHistory(EIllHistory.NOTHING);break; 
				case "CANCER":customer.setillHistory(EIllHistory.CANCER);break; 
				case "BLOODPRESURE":customer.setillHistory(EIllHistory.BLOODPRESURE);break; 
				case "GLYCOSURIA":customer.setillHistory(EIllHistory.GLYCOSURIA);break; 
				case "ACCIDENT":customer.setillHistory(EIllHistory.ACCIDENT);break; 
				default:break;
				}
				customer.setProperty(rs.getInt("property"));
				customerList.add(customer);
			}
			rs.close();
			System.out.println(customerList.size());
			System.out.println("sucess");
		} catch (Exception e) {e.printStackTrace();}
		return customerList;
	}
}
