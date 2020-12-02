package main;

import model.service.acceptInsuranceDesign.AcceptInsuranceDesign;
import model.service.acceptInsuranceDesign.AcceptInsuranceDesignImpl;
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
import model.service.insuranceDesign.InsuranceDesignList;
import model.service.insuranceDesign.InsuranceDesignListImpl;
import model.service.insuranceDevelopment.InsuranceDevelopment;
import model.service.insuranceDevelopment.InsuranceDevelopmentImpl;
import model.service.insuranceRegistration.InsuranceRegistration;
import model.service.insuranceRegistration.InsuranceRegistrationImpl;
import model.service.login.LoginList;
import model.service.login.LoginListImpl;
import model.service.salesPerson.SalesPersonList;
import model.service.salesPerson.SalesPersonListImpl;

public class MainServices {
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
	
	public MainServices(){
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
	public InsuranceDesignList getInsuranceDesignList() {return insuranceDesignList;}
	public CustomerList getCustomerList() {return customerList;}
	public InsuranceList getInsuranceList() {return insuranceList;}
	public AccidentReceiptList getAccidentReceiptList() {return accidentReceiptList;}
	public AcceptInsuranceDesign getAcceptInsuranceDesign() {return acceptInsuranceDesign;}
	public SalesPersonList getSalesPersonList() {return salesPersonList;}
	public InsuranceDevelopment getInsuranceDevelopment() {return insuranceDevelopment;}
	public InsuranceRegistration getInsuranceRegistration() {return insuranceRegistration;}
	public CheckCustomerInfo getCheckCustomerInfo() {return checkCustomerInfo;}
	public InsuranceCover getInsuranceCover() {return insuranceCover;}

	public void initialize() {
		this.acceptInsuranceDesign.associate((InsuranceDesignListImpl)this.insuranceDesignList, (InsuranceListImpl) this.insuranceList);
		this.insuranceDevelopment.associate((InsuranceDesignListImpl)this.insuranceDesignList);
		this.insuranceRegistration.associate((InsuranceListImpl)this.insuranceList, (CustomerListImpl)this.customerList, (SalesPersonListImpl)this.salesPersonList);
		this.checkCustomerInfo.associate((CustomerListImpl) this.customerList);
		this.insuranceCover.associate((AccidentReceiptListImpl)this.accidentReceiptList);
	}
}
