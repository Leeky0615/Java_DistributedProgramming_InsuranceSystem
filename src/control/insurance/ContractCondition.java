package control.insurance;

import constants.ControlConstants.EPaymentMethod;

public class ContractCondition {

	private int contractConditionID;
	private int guarantee;
	private int period;
	private int payment;
	private int paymentDate;
	private EPaymentMethod paymentMethod;
	
	
	public ContractCondition(){}

	public int getContractConditionID() {return contractConditionID;}
	public void setContractConditionID(int contractConditionID) {this.contractConditionID = contractConditionID;}
	public int getGuarantee() {return guarantee;}
	public void setGuarantee(int guaranteeAmount) {this.guarantee = guaranteeAmount;}
	public int getPeriod() {return period;}
	public void setPeriod(int insurancePeriod) {this.period = insurancePeriod;}
	public int getPayment() {return payment;}
	public void setPayment(int payment) {this.payment = payment;}
	public int getPaymentDate() {return paymentDate;}
	public void setPaymentDate(int paymentDate) {this.paymentDate = paymentDate;}
	public EPaymentMethod getPaymentType() {return paymentMethod;}
	public void setPaymentType(EPaymentMethod paymentMethod) {this.paymentMethod = paymentMethod;}
}
