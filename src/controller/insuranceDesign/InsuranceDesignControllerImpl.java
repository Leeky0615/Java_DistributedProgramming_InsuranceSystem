package controller.insuranceDesign;

import java.util.ArrayList;
import java.util.Vector;

import model.service.insuranceDesign.InsuranceDesign;
import model.service.insuranceDesign.InsuranceDesignList;
import model.service.insuranceDesign.InsuranceDesignListImpl;

public class InsuranceDesignControllerImpl implements InsuranceDesignController {
	private InsuranceDesignList insuranceDesignList;
	public InsuranceDesignControllerImpl() {
		
	}
	public void connectCtoS(InsuranceDesignListImpl insuranceDesignList) {
		this.insuranceDesignList = insuranceDesignList;
	}
	public Vector<String> getInsuranceInfo(int insuranceDesignId) {
		InsuranceDesign insuranceDesign = this.insuranceDesignList.searchById(insuranceDesignId);
		
		Vector<String> infos = new Vector<String>();
		infos.add(Integer.toString(insuranceDesign.getInsuranceDesignId()));
		infos.add(insuranceDesign.getWriter());
		infos.add(insuranceDesign.getInsurance().getInsuranceName());
		infos.add(insuranceDesign.getMadeDate());
		infos.add(Integer.toString(insuranceDesign.getInsurance().getContractCondition().getGuarantee()));
		infos.add(Integer.toString(insuranceDesign.getInsurance().getContractCondition().getPayment()));
		infos.add(Integer.toString(insuranceDesign.getInsurance().getContractCondition().getPeriod()));
		infos.add(insuranceDesign.getInsurance().getInsuranceType().getText());
		infos.add(insuranceDesign.getInsurance().getInsuranceDescription());
		return infos;
	}
	
	public ArrayList<InsuranceDesign> getInsuranceDesignList() {
		return this.insuranceDesignList.getInsuranceDesignList();
	}
}
