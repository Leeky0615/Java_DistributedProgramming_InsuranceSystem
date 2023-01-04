package model.entity;

import constants.ControlConstants.EPaymentMethod;

public class CancerInsurance extends Insurance{

	private int paymentDate;
	private EPaymentMethod paymentMethod;
	private int insuranceId;
	private int customerId;

	public CancerInsurance(){}

	public int getPaymentDate() {return paymentDate;}
	public void setPaymentDate(int paymentDate) {this.paymentDate = paymentDate;}
	public EPaymentMethod getPaymentMethod() {return paymentMethod;}
	public void setPaymentMethod(EPaymentMethod paymentMethod) {this.paymentMethod = paymentMethod;}
	public int getInsuranceId() {return insuranceId;}
	public void setInsuranceId(int insuranceId) {this.insuranceId = insuranceId;}
	public int getCustomerId() {return customerId;}
	public void setCustomerId(int customerId) {this.customerId = customerId;}

	public float calculateRate(Customer targetCustomer) {
		float rate =0;

		return rate;
	}
}
