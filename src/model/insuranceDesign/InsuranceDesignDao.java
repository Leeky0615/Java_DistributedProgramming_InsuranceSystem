package model.insuranceDesign;

import java.util.ArrayList;

import constants.ViewConstants.EApprovalStatus;
import control.insuranceDevelopment.InsuranceDesign;

public interface InsuranceDesignDao {

	public ArrayList<InsuranceDesign> select();
	public void update(EApprovalStatus approvalins, int insuranceDesignId, int insuranceId);
	public void delete(int insuranceDesignId);
}
