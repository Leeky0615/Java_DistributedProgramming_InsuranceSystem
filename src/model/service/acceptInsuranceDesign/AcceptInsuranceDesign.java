package model.service.acceptInsuranceDesign;

import model.service.insurance.InsuranceListImpl;
import model.service.insuranceDesign.InsuranceDesignListImpl;

public interface AcceptInsuranceDesign {
	public void approve(int insuranceDesignId);
	public void disapprove(int insuranceDesignId);
	public void associate(InsuranceDesignListImpl insuranceDesignList, InsuranceListImpl insuranceList);
}