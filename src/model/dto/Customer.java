package model.dto;

import constants.ControlConstants.EIllHistory;
import constants.ControlConstants.EJob;
import model.service.insurance.InsuranceListImpl;

public class Customer {
	
	private int id;
	private String name;
	private String customerSID;
	private boolean gender;
	private int age;
	private String phoneNum;
	private EJob job;
	private EIllHistory illHistory;
	private int property;
	private boolean registrationStatus;
	
	private InsuranceListImpl InsuranceList;
	
	public Customer(){}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getCustomerSID() {return customerSID;}
	public void setCustomerSID(String customerSID) {this.customerSID = customerSID;}
	public int getGenderString() {
		if (gender) {return 1;}
		else {return 0;}
	}
	public String isGenderString() {
		if (gender) {return "여성";}
		else {return "남성";}
	}
	public void setGender(boolean gender) {this.gender = gender;}
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	public String getPhoneNum() {return phoneNum;}
	public void setPhoneNum(String phoneNum) {this.phoneNum = phoneNum;}
	public EJob getJob() {return job;}
	public void setJob(EJob job) {this.job = job;}
	public EIllHistory getIllHistory() {
		return illHistory;
	}

	public void setIllHistory(EIllHistory illHistory) {
		this.illHistory = illHistory;
	}

	public void setProperty(int property) {this.property = property;}
	public int getProperty() {return property;}
	public boolean isRegistrationStatus() {return registrationStatus;}
	public void setRegistrationStatus(boolean registrationStatus) {this.registrationStatus = registrationStatus;}
	public InsuranceListImpl getInsuranceList() {return InsuranceList;}
	public void setInsuranceList(InsuranceListImpl insuranceList) {InsuranceList = insuranceList;}



}