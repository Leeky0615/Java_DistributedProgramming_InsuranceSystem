package view.acceptinspanel;

import java.util.Vector;

import constants.ViewConstants.EApprovalStatus;
import model.dto.InsuranceDesign;
import model.service.insuranceDevelopment.InsuranceDesignListImpl;
import view.defaultClass.Default_InsuranceDesignTable;

public class InsuranceDesignTable extends Default_InsuranceDesignTable {
	private static final long serialVersionUID = 1L;
	
	private InsuranceDesignListImpl insuranceDesignList;

	public InsuranceDesignTable(InsuranceDesignListImpl insuranceDesignList, boolean acceptState) {
		super();
		this.insuranceDesignList = insuranceDesignList;
		this.refresh(acceptState);
	}

	public void refresh(boolean acceptState) {
		this.rowData.clear();
		for (InsuranceDesign insuranceDesign : this.insuranceDesignList.getInsuranceDesignList()) {
			Vector<Object> insuranceDesigns = new Vector<Object>();
			// 승인요청 중인 보험을 보여주는 테이블
			if (acceptState) {
				if (insuranceDesign.getApprovalStatus().equals(EApprovalStatus.ApprovalIns) || insuranceDesign.getApprovalStatus().equals(EApprovalStatus.DisApprovalIns)) {
					insuranceDesigns.add(insuranceDesign.getInsuranceDesignId());
					insuranceDesigns.add(insuranceDesign.getWriter());
					insuranceDesigns.add(insuranceDesign.getInsurance().getInsuranceName());
					insuranceDesigns.add(insuranceDesign.getInsurance().getInsuranceType().getText());
					insuranceDesigns.add(insuranceDesign.getMadeDate());
					insuranceDesigns.add(insuranceDesign.getApprovalStatus().getText());
					this.rowData.add(insuranceDesigns);
				}
			// 승인 결과가 나온 보험을 보여주는 테이블
			}else {
				System.out.println(insuranceDesign.getApprovalStatus());
				if (insuranceDesign.getApprovalStatus().equals(EApprovalStatus.RequestInsDesign)) {
					insuranceDesigns.add(insuranceDesign.getInsuranceDesignId());
					insuranceDesigns.add(insuranceDesign.getWriter());
					insuranceDesigns.add(insuranceDesign.getInsurance().getInsuranceName());
					insuranceDesigns.add(insuranceDesign.getInsurance().getInsuranceType().getText());
					insuranceDesigns.add(insuranceDesign.getMadeDate());
					insuranceDesigns.add(insuranceDesign.getApprovalStatus().getText());
					this.rowData.add(insuranceDesigns);
				}
			}
		}
		this.updateUI();
	}
}
