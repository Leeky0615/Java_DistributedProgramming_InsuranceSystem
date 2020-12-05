package controller.insurance;

import java.util.ArrayList;

import model.dto.Insurance;
import model.service.insurance.InsuranceListImpl;

public class InsuranceControllerImpl implements InsuranceController {
	private InsuranceListImpl insuranceList;
	
	public InsuranceControllerImpl() {}

	public void connectCtoS(InsuranceListImpl insuranceList) {
		this.insuranceList = insuranceList;
	}

	public ArrayList<Insurance> getInsuranceList() {
		return this.insuranceList.getInsuranceList();
	}
}
