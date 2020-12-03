package model.service.insurance;

import constants.ControlConstants.EInsuranceType;

public class Insurance {
	private int insuranceId;
	private EInsuranceType insuranceType;
	private String insuranceDescription;
	private String insuranceName;
	private int contractConditionId;
	
	private ContractCondition contractCondition;

	public Insurance(){
		this.contractCondition = new ContractCondition();
	}
	
	public int getInsuranceId() {return insuranceId;}
	public void setInsuranceId(int insuranceId) {this.insuranceId = insuranceId;}
	public EInsuranceType getInsuranceType() {return insuranceType;}
	public void setInsuranceType(EInsuranceType insuranceType) {this.insuranceType = insuranceType;}
	public String getInsuranceDescription() {return insuranceDescription;}
	public void setInsuranceDescription(String insuranceDescription) {this.insuranceDescription = insuranceDescription;}
	public String getInsuranceName() {return insuranceName;}
	public void setInsuranceName(String insuranceName) {this.insuranceName = insuranceName;}
	public int getContractConditionId() {return contractConditionId;}
	public void setContractConditionId(int contractConditionId) {this.contractConditionId = contractConditionId;}
	
	public ContractCondition getContractCondition() {return contractCondition;}
	public void setContractCondition(ContractCondition contractCondition) {this.contractCondition = contractCondition;}
}