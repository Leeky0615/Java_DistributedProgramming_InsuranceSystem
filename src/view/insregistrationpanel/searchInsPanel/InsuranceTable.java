package view.insregistrationpanel.searchInsPanel;

import java.util.Vector;

import control.insurance.Insurance;
import control.insurance.InsuranceListImpl;
import view.defaultClass.Default_InsuranceTable;

public class InsuranceTable extends Default_InsuranceTable{
	private static final long serialVersionUID = 1L;
	private InsuranceListImpl insuranceList;
	
	public InsuranceTable(InsuranceListImpl insurancerList, String insuranceType) {
		super();
		this.insuranceList = insurancerList;
		this.refresh(insuranceType);
	}
	
	public void addRowData(Insurance insurance) {
		Vector<Object> insuranceRow = new Vector<Object>();
		insuranceRow.add(insurance.getInsuranceId());
		insuranceRow.add(insurance.getInsuranceName());
		insuranceRow.add(insurance.getContractCondition().getGuarantee()+"원");
		insuranceRow.add(insurance.getContractCondition().getPayment()+"원");
		insuranceRow.add(insurance.getContractCondition().getPeriod()+"년");
		insuranceRow.add(insurance.getInsuranceType().getText());
		this.rowData.add(insuranceRow);
	}
	
	public void refresh(String insuranceType) {
		this.rowData.clear();
		for (Insurance insurance : this.insuranceList.getInsuranceList()) {
			if (insuranceType.equals("전체")) {this.addRowData(insurance);}
			else {
				if (insurance.getInsuranceType().getText().equals(insuranceType)) {this.addRowData(insurance);}
			}
		}
		updateUI();
	}
}
