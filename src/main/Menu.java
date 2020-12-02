package main;

import model.service.acceptInsuranceDesign.AcceptInsDesign;
import model.service.acceptInsuranceDesign.AcceptInsDesignImpl;
import model.service.accidentReceipt.AccidentReceiptList;
import model.service.accidentReceipt.AccidentReceiptListImpl;
import model.service.checkCustomerInfo.CheckCustomerInfo;
import model.service.checkCustomerInfo.CheckCustomerInfoImpl;
import model.service.customer.CustomerList;
import model.service.customer.CustomerListImpl;
import model.service.insurance.InsuranceList;
import model.service.insurance.InsuranceListImpl;
import model.service.insuranceCover.InsuranceCover;
import model.service.insuranceCover.InsuranceCoverImpl;
import model.service.insuranceDevelopment.InsuranceDesignList;
import model.service.insuranceDevelopment.InsuranceDesignListImpl;
import model.service.insuranceDevelopment.InsuranceDevelopment;
import model.service.insuranceDevelopment.InsuranceDevelopmentImpl;
import model.service.insuranceRegistration.InsuranceRegistration;
import model.service.insuranceRegistration.InsuranceRegistrationImpl;
import model.service.login.LoginList;
import model.service.login.LoginListImpl;
import model.service.salesPerson.SalesPersonList;
import model.service.salesPerson.SalesPersonListImpl;

public class Menu {
	private InsuranceDesignList insuranceDesignList;
	private CustomerList customerList;
	private InsuranceList insuranceList;
	private AccidentReceiptList accidentReceiptList;
	private SalesPersonList salesPersonList;
	private LoginList loginlist;
	
	private AcceptInsDesign acceptInsuranceDesign;
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
		
		this.acceptInsuranceDesign = new AcceptInsDesignImpl();
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
	public AcceptInsDesign getAcceptInsuranceDesign() {return acceptInsuranceDesign;}
	public void setAcceptInsuranceDesign(AcceptInsDesign acceptInsuranceDesign) {this.acceptInsuranceDesign = acceptInsuranceDesign;}
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