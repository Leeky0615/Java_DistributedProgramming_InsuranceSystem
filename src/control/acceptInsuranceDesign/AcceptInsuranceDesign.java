package control.acceptInsuranceDesign;

import control.insurance.InsuranceListImpl;
import control.insuranceDevelopment.InsuranceDesignListImpl;

public interface AcceptInsuranceDesign {
	public void approve(int insuranceDesignId);
	public void disapprove(int insuranceDesignId);
	public void associate(InsuranceDesignListImpl insuranceDesignList, InsuranceListImpl insuranceList);
}