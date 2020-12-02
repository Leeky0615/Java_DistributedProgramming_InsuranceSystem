package controller.acceptInsuranceDesign;

import model.service.acceptInsuranceDesign.AcceptInsuranceDesignImpl;

public interface AcceptInsDesignController {
	public void connectCtoS(AcceptInsuranceDesignImpl acceptInsuranceDesign);
	public void approve(int insuranceDesignId);
	public void disapprove(int insuranceDesignId);
}