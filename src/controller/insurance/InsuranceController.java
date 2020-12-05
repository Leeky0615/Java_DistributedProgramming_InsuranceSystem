package controller.insurance;

import java.util.ArrayList;

import model.dto.Insurance;
import model.service.insurance.InsuranceListImpl;

public interface InsuranceController {
	public void connectCtoS(InsuranceListImpl insuranceList);
	public ArrayList<Insurance> getInsuranceList();
}
