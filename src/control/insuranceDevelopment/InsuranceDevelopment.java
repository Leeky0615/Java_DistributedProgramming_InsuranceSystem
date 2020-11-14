package control.insuranceDevelopment;

import java.util.Vector;

import constants.ViewConstants.EApprovalStatus;

public interface InsuranceDevelopment {
	public void designInsurance(Vector<String> Infos);
	public EApprovalStatus requestApproval();
	public void associate(InsuranceDesignListImpl insuranceDesignList);
}
