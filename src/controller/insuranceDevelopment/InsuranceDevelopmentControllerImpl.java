package controller.insuranceDevelopment;

import java.util.Vector;

import model.service.insuranceDevelopment.InsuranceDevelopmentImpl;

public class InsuranceDevelopmentControllerImpl implements InsuranceDevelopmentController {
	private InsuranceDevelopmentImpl insuranceDevelopment;
	
	public InsuranceDevelopmentControllerImpl() {
		
	}

	public void connectCtoS(InsuranceDevelopmentImpl insuranceDevelopment) {
		this.insuranceDevelopment = insuranceDevelopment;
	}

	public void designInsurance(Vector<String> infos) {
		this.insuranceDevelopment.designInsurance(infos);
	}
}
