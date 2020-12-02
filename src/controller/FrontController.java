package controller;

import controller.acceptInsuranceDesign.AcceptInsDesignController;
import controller.acceptInsuranceDesign.AcceptInsDesignControllerImpl;
import controller.accidentReceipt.AccidentReceiptController;
import controller.accidentReceipt.AccidentReceiptControllerImpl;
import controller.checkCustomerInfo.CheckCustomerInfController;
import controller.checkCustomerInfo.CheckCustomerInfoControllerImpl;
import controller.customer.CustomerController;
import controller.customer.CustomerControllerImpl;
import controller.insurance.InsuranceController;
import controller.insurance.InsuranceControllerImpl;
import controller.insuranceCover.InsuranceCoverController;
import controller.insuranceCover.InsuranceCoverControllerImpl;
import controller.insuranceDesign.InsuranceDesignController;
import controller.insuranceDesign.InsuranceDesignControllerImpl;
import controller.insuranceDevelopment.InsuranceDevelopmentController;
import controller.insuranceDevelopment.InsuranceDevelopmentControllerImpl;
import controller.insuranceRegistration.InsuranceRegistrationController;
import controller.insuranceRegistration.InsuranceRegistrationControllerImpl;
import controller.login.LoginController;
import controller.login.LoginControllerImpl;
import controller.salesPerson.SalesPersonController;
import controller.salesPerson.SalesPersonControllerImpl;

public class FrontController {
	private InsuranceDesignController insuranceDesignController;
	private CustomerController customerController;
	private InsuranceController insuranceController;
	private AccidentReceiptController accidentReceiptController;
	private SalesPersonController salesPersonController;
	private LoginController loginController;
	
	private AcceptInsDesignController acceptInsuranceDesignController;
	private InsuranceDevelopmentController insuranceDevelopmentController;
	private InsuranceRegistrationController insuranceRegistrationController;
	private CheckCustomerInfController checkCustomerInfoController;
	private InsuranceCoverController insuranceCoverController;
	
	
	public FrontController(){
		this.insuranceDesignController = new InsuranceDesignControllerImpl();
		this.insuranceController = new InsuranceControllerImpl();
		this.customerController = new CustomerControllerImpl();
		this.accidentReceiptController = new AccidentReceiptControllerImpl();
		this.salesPersonController = new SalesPersonControllerImpl();
		this.loginController = new LoginControllerImpl();
		
		this.acceptInsuranceDesignController = new AcceptInsDesignControllerImpl();
		this.insuranceDevelopmentController = new InsuranceDevelopmentControllerImpl();
		this.insuranceRegistrationController = new InsuranceRegistrationControllerImpl();
		this.checkCustomerInfoController = new CheckCustomerInfoControllerImpl();
		this.insuranceCoverController = new InsuranceCoverControllerImpl();
	}

	public Object mappingController(String className){
		switch (className) {
		case "InsuranceDesignController": return this.insuranceDesignController;
		case "InsuranceController": return this.insuranceController;
		case "CustomerController": return this.customerController;
		case "AccidentReceiptController": return this.accidentReceiptController;
		case "SalesPersonController": return this.salesPersonController;
		case "LoginController": return this.loginController;
		case "AcceptInsDesignController": return this.acceptInsuranceDesignController;
		case "InsuranceDevelopmentController": return this.insuranceDevelopmentController;
		case "InsuranceRegistrationController": return this.insuranceRegistrationController;
		case "CheckCustomerInfoController": return this.checkCustomerInfoController;
		case "InsuranceCoverController": return this.insuranceCoverController;
		default:break;
		}
		return null;
	}
}