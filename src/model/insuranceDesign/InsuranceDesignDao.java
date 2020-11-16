package model.insuranceDesign;

import java.util.ArrayList;

import constants.ViewConstants.EApprovalStatus;
import control.insuranceDevelopment.InsuranceDesign;

public interface InsuranceDesignDao {

	public ArrayList<InsuranceDesign> select();
	public void update(InsuranceDesign insuranceDesign);
	public void delete(int insuranceDesignId);
}
