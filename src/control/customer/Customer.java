package control.customer;

import constants.ControlConstants.EIllHistory;
import constants.ControlConstants.EJob;
import control.insurance.InsuranceListImpl;

public class Customer {
	
	private int id;
	private int age;
	private String customerId;
	private boolean gender;
	private EJob job;
	private EIllHistory illHistory;
	private String name;
	private String phoneNum;
	private int property;
	private boolean registrationStatus;
	private InsuranceListImpl InsuranceList;
	
	public Customer(){
	}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public boolean isRegistrationStatus() {return registrationStatus;}
	public void setRegistrationStatus(boolean registrationStatus) {this.registrationStatus = registrationStatus;}
	public InsuranceListImpl getInsuranceList() {return InsuranceList;}
	public void setInsuranceList(InsuranceListImpl insuranceList) {InsuranceList = insuranceList;}

	public EJob getJob() {return job;}
	public void setJob(EJob job) {this.job = job;}
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	public void setProperty(int property) {this.property = property;}
	public int getProperty() {return property;}
	public String getCustomerId() {return customerId;}
	public void setCustomerId(String customerId) {this.customerId = customerId;}
	public int getGender() {
		if (gender) {return 1;}
		else {return 0;}
	}
	public String isGender() {
		if (gender) {return "여성";}
		else {return "남성";}
	}
	public void setGender(boolean gender) {this.gender = gender;}
	public EIllHistory getillHistory() {return illHistory;}
	public void setillHistory(EIllHistory illHistory) {this.illHistory = illHistory;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getPhoneNum() {return phoneNum;}
	public void setPhoneNum(String phoneNum) {this.phoneNum = phoneNum;}
}