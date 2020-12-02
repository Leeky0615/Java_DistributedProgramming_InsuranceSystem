package controller.acceptInsuranceDesign;

import model.service.acceptInsuranceDesign.AcceptInsuranceDesign;
import model.service.acceptInsuranceDesign.AcceptInsuranceDesignImpl;

public class AcceptInsDesignControllerImpl implements AcceptInsDesignController {
	private AcceptInsuranceDesign acceptInsDesign;
	
	public AcceptInsDesignControllerImpl() {
		
	}
	public void connectCtoS(AcceptInsuranceDesignImpl acceptInsuranceDesign) {
		this.acceptInsDesign = acceptInsuranceDesign; 
	}
	public void approve(int insuranceDesignId) {this.acceptInsDesign.approve(insuranceDesignId);}
	public void disapprove(int insuranceDesignId) {this.acceptInsDesign.disapprove(insuranceDesignId);}
}
