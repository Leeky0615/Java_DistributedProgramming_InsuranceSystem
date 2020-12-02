package constants;

public class ControllerConstants {
	public enum EController{
		InsuranceDesignController("InsuranceDesignController"),
		InsuranceController("InsuranceController"),
		CustomerController("CustomerController"),
		AccidentReceiptController("AccidentReceiptController"),
		SalesPersonController("SalesPersonController"),
		LoginController("LoginController"),
		AcceptInsDesignController("AcceptInsDesignController"),
		InsuranceDevelopmentController("InsuranceDevelopmentController"),
		InsuranceRegistrationController("InsuranceRegistrationController"),
		CheckCustomerInfoController("CheckCustomerInfoController"),
		InsuranceCoverController("InsuranceCoverController");
		private String controllerName;
		private EController(String controllerName) {this.controllerName = controllerName;}
		public String getControllerName() {return this.controllerName;}
	}
}
