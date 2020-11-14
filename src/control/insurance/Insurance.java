package control.insurance;

import constants.ControlConstants.EInsuranceType;
import control.customer.Customer;

public abstract class Insurance {
	protected EInsuranceType insuranceType;
	protected ContractCondition contractCondition;
	protected int insuraceId;
	protected String insuranceDescription;
	protected String insuranceName;

	public Insurance(){
		this.contractCondition = new ContractCondition();
	}
	
	public EInsuranceType getInsuranceType() {return insuranceType;}
	public void setInsuranceType(EInsuranceType insuranceType) {this.insuranceType = insuranceType;}
	public abstract float calculateRate(Customer customer);
	public ContractCondition getContractCondition() {return contractCondition;}
	public void setContractCondition(ContractCondition contractCondition) {this.contractCondition = contractCondition;}
	public int getInsuranceId() {return insuraceId;}
	public void setInsuranceId(int insuraceId) {this.insuraceId = insuraceId;}
	public String getInsuranceDescription() {return insuranceDescription;}
	public void setInsuranceDescription(String insuranceDescription) {this.insuranceDescription = insuranceDescription;}
	public String getInsuranceName() {return insuranceName;}
	public void setInsuranceName(String insuranceName) {this.insuranceName = insuranceName;}
}