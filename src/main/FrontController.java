package main;

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
import model.service.acceptInsuranceDesign.AcceptInsuranceDesignImpl;
import model.service.accidentReceipt.AccidentReceiptListImpl;
import model.service.checkCustomerInfo.CheckCustomerInfoImpl;
import model.service.customer.CustomerListImpl;
import model.service.insurance.InsuranceListImpl;
import model.service.insuranceCover.InsuranceCoverImpl;
import model.service.insuranceDesign.InsuranceDesignListImpl;
import model.service.insuranceDevelopment.InsuranceDevelopmentImpl;
import model.service.insuranceRegistration.InsuranceRegistrationImpl;
import model.service.login.LoginListImpl;
import model.service.salesPerson.SalesPersonListImpl;

public class FrontController {
    private final InsuranceDesignController insuranceDesignController;
    private final CustomerController customerController;
    private final InsuranceController insuranceController;
    private final AccidentReceiptController accidentReceiptController;
    private final SalesPersonController salesPersonController;
    private final LoginController loginController;

    private final AcceptInsDesignController acceptInsuranceDesignController;
    private final InsuranceDevelopmentController insuranceDevelopmentController;
    private final InsuranceRegistrationController insuranceRegistrationController;
    private final CheckCustomerInfController checkCustomerInfoController;
    private final InsuranceCoverController insuranceCoverController;

    private MainServices mainServices;

    public FrontController() {
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

    /**
     * 컨트롤러랑 서비스를 연결??
     */
    public void connectCtoS() {
        this.insuranceDesignController.connectCtoS((InsuranceDesignListImpl) this.mainServices.getInsuranceDesignList());
        this.insuranceController.connectCtoS((InsuranceListImpl) this.mainServices.getInsuranceList());
        this.customerController.connectCtoS((CustomerListImpl) this.mainServices.getCustomerList());
        this.accidentReceiptController.connectCtoS((AccidentReceiptListImpl) this.mainServices.getAccidentReceiptList());
        this.salesPersonController.connectCtoS((SalesPersonListImpl) this.mainServices.getSalesPersonList());
        this.loginController.connectCtoS((LoginListImpl) this.mainServices.getLoginlist());

        this.acceptInsuranceDesignController.connectCtoS((AcceptInsuranceDesignImpl) this.mainServices.getAcceptInsuranceDesign());
        this.insuranceDevelopmentController.connectCtoS((InsuranceDevelopmentImpl) this.mainServices.getInsuranceDevelopment());
        this.insuranceRegistrationController.connectCtoS((InsuranceRegistrationImpl) this.mainServices.getInsuranceRegistration());
        this.checkCustomerInfoController.connectCtoS((CheckCustomerInfoImpl) this.mainServices.getCheckCustomerInfo());
        this.insuranceCoverController.connectCtoS((InsuranceCoverImpl) this.mainServices.getInsuranceCover());
    }

    public void associate(MainServices mainServices) {
        this.mainServices = mainServices;
    }

    public Object mappingController(String className) {
        switch (className) {
            case "InsuranceDesignController":
                return this.insuranceDesignController;
            case "InsuranceController":
                return this.insuranceController;
            case "CustomerController":
                return this.customerController;
            case "AccidentReceiptController":
                return this.accidentReceiptController;
            case "SalesPersonController":
                return this.salesPersonController;
            case "LoginController":
                return this.loginController;
            case "AcceptInsDesignController":
                return this.acceptInsuranceDesignController;
            case "InsuranceDevelopmentController":
                return this.insuranceDevelopmentController;
            case "InsuranceRegistrationController":
                return this.insuranceRegistrationController;
            case "CheckCustomerInfoController":
                return this.checkCustomerInfoController;
            case "InsuranceCoverController":
                return this.insuranceCoverController;
            default:
                break;
        }
        return null;
    }


}
