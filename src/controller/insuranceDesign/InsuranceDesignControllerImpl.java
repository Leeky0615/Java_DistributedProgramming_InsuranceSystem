package controller.insuranceDesign;

import java.util.Vector;

import model.dto.InsuranceDesign;
import model.service.insuranceDesign.InsuranceDesignList;
import model.service.insuranceDesign.InsuranceDesignListImpl;

public class InsuranceDesignControllerImpl implements InsuranceDesignController {
	private InsuranceDesignList insuranceDesignList;
	public InsuranceDesignControllerImpl() {
		this.insuranceDesignList = new InsuranceDesignListImpl();
	}
	public Vector<String> setInsuranceInfo(Integer integer) {
		InsuranceDesign insuranceDesign = this.insuranceDesignList.searchById(integer);
		
		Vector<String> infos = new Vector<String>();
		infos.add(Integer.toString(this.insuranceDesign.getInsuranceDesignId()));
		infos.add(this.insuranceDesign.getWriter());
		infos.add(this.insuranceDesign.getInsurance().getInsuranceName());
		infos.add(this.insuranceDesign.getMadeDate());
		infos.add(Integer.toString(this.insuranceDesign.getInsurance().getContractCondition().getGuarantee()));
		infos.add(Integer.toString(this.insuranceDesign.getInsurance().getContractCondition().getPayment()));
		infos.add(Integer.toString(this.insuranceDesign.getInsurance().getContractCondition().getPeriod()));
		infos.add(this.insuranceDesign.getInsurance().getInsuranceType().getText());
		infos.add(this.insuranceDesign.getInsurance().getInsuranceDescription());
		
		return infos;
	}
}
