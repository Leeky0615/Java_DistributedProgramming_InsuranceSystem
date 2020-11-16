package main;

import control.acceptInsuranceDesign.AcceptInsuranceDesign;
import control.acceptInsuranceDesign.AcceptInsuranceDesignImpl;
import control.accidentReciept.AccidentReceiptList;
import control.accidentReciept.AccidentReceiptListImpl;
import control.checkCustomerInfo.CheckCustomerInfo;
import control.checkCustomerInfo.CheckCustomerInfoImpl;
import control.customer.CustomerList;
import control.customer.CustomerListImpl;
import control.insurance.InsuranceList;
import control.insurance.InsuranceListImpl;
import control.insuranceCover.InsuranceCover;
import control.insuranceCover.InsuranceCoverImpl;
import control.insuranceDevelopment.InsuranceDesignList;
import control.insuranceDevelopment.InsuranceDesignListImpl;
import control.insuranceDevelopment.InsuranceDevelopment;
import control.insuranceDevelopment.InsuranceDevelopmentImpl;
import control.insuranceRegistration.InsuranceRegistration;
import control.insuranceRegistration.InsuranceRegistrationImpl;
import control.login.LoginList;
import control.login.LoginListImpl;
import control.salesPerson.SalesPersonList;
import control.salesPerson.SalesPersonListImpl;

public class Menu {
	private InsuranceDesignList insuranceDesignList;
	private CustomerList customerList;
	private InsuranceList insuranceList;
	private AccidentReceiptList accidentReceiptList;
	private SalesPersonList salesPersonList;
	private LoginList loginlist;
	
	private AcceptInsuranceDesign acceptInsuranceDesign;
	private InsuranceDevelopment insuranceDevelopment;
	private InsuranceRegistration insuranceRegistration;
	private CheckCustomerInfo checkCustomerInfo;
	private InsuranceCover insuranceCover;
	
	
	public Menu(){
		this.insuranceDesignList = new InsuranceDesignListImpl();
		this.insuranceList = new InsuranceListImpl();
		this.customerList = new CustomerListImpl();
		this.accidentReceiptList = new AccidentReceiptListImpl();
		this.salesPersonList = new SalesPersonListImpl();
		this.loginlist = new LoginListImpl();
		
		this.acceptInsuranceDesign = new AcceptInsuranceDesignImpl();
		this.insuranceDevelopment = new InsuranceDevelopmentImpl();
		this.insuranceRegistration = new InsuranceRegistrationImpl();
		this.checkCustomerInfo = new CheckCustomerInfoImpl();
		this.insuranceCover = new InsuranceCoverImpl();
	}


	public LoginList getLoginlist() {return loginlist;}
	public void setLoginlist(LoginList loginlist) {this.loginlist = loginlist;}
	public InsuranceDesignList getInsuranceDesignList() {return insuranceDesignList;}
	public void setInsuranceDesignList(InsuranceDesignList insuranceDesignList) {this.insuranceDesignList = insuranceDesignList;}
	public CustomerList getCustomerList() {return customerList;}
	public void setCustomerList(CustomerList customerList) {this.customerList = customerList;}
	public InsuranceList getInsuranceList() {return insuranceList;}
	public void setInsuranceList(InsuranceList insuranceList) {this.insuranceList = insuranceList;}
	public AccidentReceiptList getAccidentReceiptList() {return accidentReceiptList;}
	public void setAccidentReceiptList(AccidentReceiptList accidentReceiptList) {this.accidentReceiptList = accidentReceiptList;}
	public AcceptInsuranceDesign getAcceptInsuranceDesign() {return acceptInsuranceDesign;}
	public void setAcceptInsuranceDesign(AcceptInsuranceDesign acceptInsuranceDesign) {this.acceptInsuranceDesign = acceptInsuranceDesign;}
	public SalesPersonList getSalesPersonList() {return salesPersonList;}
	public void setSalesPersonList(SalesPersonList salesPersonList) {this.salesPersonList = salesPersonList;}
	public InsuranceDevelopment getInsuranceDevelopment() {return insuranceDevelopment;}
	public void setInsuranceDevelopment(InsuranceDevelopment insuranceDevelopment) {this.insuranceDevelopment = insuranceDevelopment;}
	public InsuranceRegistration getInsuranceRegistration() {return insuranceRegistration;}
	public void setInsuranceRegistration(InsuranceRegistration insuranceRegistration) {this.insuranceRegistration = insuranceRegistration;}
	public CheckCustomerInfo getCheckCustomerInfo() {return checkCustomerInfo;}
	public void setCheckCustomerInfo(CheckCustomerInfo checkCustomerInfo) {this.checkCustomerInfo = checkCustomerInfo;}
	public InsuranceCover getInsuranceCover() {return insuranceCover;}
	public void setInsuranceCover(InsuranceCover insuranceCover) {this.insuranceCover = insuranceCover;}

	public void associate() {
		this.acceptInsuranceDesign.associate((InsuranceDesignListImpl)this.insuranceDesignList, (InsuranceListImpl) this.insuranceList);
		this.insuranceDevelopment.associate((InsuranceDesignListImpl)this.insuranceDesignList);
		this.insuranceRegistration.associate((InsuranceListImpl)this.insuranceList, (CustomerListImpl)this.customerList, (SalesPersonListImpl)this.salesPersonList);
		this.checkCustomerInfo.associate((CustomerListImpl) this.customerList);
		this.insuranceCover.associate((AccidentReceiptListImpl)this.accidentReceiptList);
	}
}