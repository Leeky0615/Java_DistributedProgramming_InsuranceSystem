package model.service.insuranceDevelopment;

import java.util.Vector;

import constants.ViewConstants.EApprovalStatus;
import model.service.insuranceDesign.InsuranceDesignListImpl;

public interface InsuranceDevelopment {
	public void designInsurance(Vector<String> Infos);
	public EApprovalStatus requestApproval();
	public void associate(InsuranceDesignListImpl insuranceDesignList);
}
