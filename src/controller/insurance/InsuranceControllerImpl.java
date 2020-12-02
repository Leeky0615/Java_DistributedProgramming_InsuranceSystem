package controller.insurance;

import model.service.insurance.InsuranceListImpl;

public class InsuranceControllerImpl implements InsuranceController {
	private InsuranceListImpl insuranceList;
	
	public InsuranceControllerImpl() {
		
	}

	public void connectCtoS(InsuranceListImpl insuranceList) {
		this.insuranceList = insuranceList;
	}
}
