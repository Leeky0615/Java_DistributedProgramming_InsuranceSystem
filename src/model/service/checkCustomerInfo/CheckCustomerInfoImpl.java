package model.service.checkCustomerInfo;

import java.util.Vector;

import constants.ControlConstants.EIllHistory;
import constants.ControlConstants.EJob;
import constants.ViewConstants.ECustomer;
import model.dao.customer.CustomerDao;
import model.dao.customer.CustomerDaoImpl;
import model.service.customer.Customer;
import model.service.customer.CustomerListImpl;

public class CheckCustomerInfoImpl implements CheckCustomerInfo {

	private CustomerListImpl customerList;
	private CustomerDao customerDao;
	public CheckCustomerInfoImpl(){
		this.customerDao = new CustomerDaoImpl();
	}
	
	public void associate(CustomerListImpl customerList) {this.customerList = customerList;}
	public Customer searchCustomerbyId(String customerId){return this.customerList.searchById(customerId);}

	public void addNewCustomerInformation(Vector<String> customerContents){
		Customer customer = new Customer();
		for(ECustomer eCustomer : ECustomer.values()) {
			String value = customerContents.get(eCustomer.ordinal());
			switch (eCustomer.getText()) {
			case "이름": customer.setName(value);break;
			case "주민등록번호": customer.setCustomerSID(value);break;
			case "성별": 
				if (value.equals("남성")) {customer.setGender(false);}
				else {customer.setGender(true);}
				break;
			case "나이":customer.setAge(Integer.parseInt(value));break;
			case "전화번호": customer.setPhoneNum(value);break;
			case "직업": 
				switch (value) {
				case "군인":customer.setJob(EJob.SOLDIER);break;
				case "경찰":customer.setJob(EJob.POLICE);break;
				case "소방관":customer.setJob(EJob.FIREMAN);break;
				case "운전기사":customer.setJob(EJob.DRIVER);break;
				case "무직":customer.setJob(EJob.NO_JOB);break;
				default:break;
				}
				break;
			case "병력": 
				switch (value) {
				case "없음":customer.setillHistory(EIllHistory.NOTHING);break;
				case "암":customer.setillHistory(EIllHistory.CANCER);break;
				case "혈압":customer.setillHistory(EIllHistory.BLOODPRESURE);break;
				case "당뇨":customer.setillHistory(EIllHistory.GLYCOSURIA);break;
				case "사고":customer.setillHistory(EIllHistory.ACCIDENT);break;
				default:break;
				}
				break;
			case "재산": customer.setProperty(Integer.parseInt(value));break;
			case "지급 방법": 
			default: break;
			}
		}
		this.customerList.add(customer);
		this.customerDao.insert(customer);
	}
}