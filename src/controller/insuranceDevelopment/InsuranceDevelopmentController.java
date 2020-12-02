package controller.insuranceDevelopment;

import java.util.Vector;

import model.service.insuranceDevelopment.InsuranceDevelopmentImpl;

public interface InsuranceDevelopmentController {
	public void connectCtoS(InsuranceDevelopmentImpl insuranceDevelopment);
	public void designInsurance(Vector<String> infos);
}
