package model.service.insurance;

public class ContractCondition {

	private int contractConditionId;
	private int guarantee;
	private int period;
	private int payment;
	
	
	public ContractCondition(){}

	public int getContractConditionID() {return contractConditionId;}
	public void setContractConditionID(int contractConditionID) {this.contractConditionId = contractConditionID;}
	public int getGuarantee() {return guarantee;}
	public void setGuarantee(int guaranteeAmount) {this.guarantee = guaranteeAmount;}
	public int getPeriod() {return period;}
	public void setPeriod(int insurancePeriod) {this.period = insurancePeriod;}
	public int getPayment() {return payment;}
	public void setPayment(int payment) {this.payment = payment;}
}
