package control.insurance;

import constants.ControlConstants.EPaymentMethod;
import control.customer.Customer;

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
		
		if(targetCustomer.isGender().equals("����")) {rate*=0.9;}
		else {rate*=1.1;}
		
		if(targetCustomer.getAge()<10) {rate*=0.5;
		}else if(targetCustomer.getAge()<20) { rate*=0.7;
		}else if(targetCustomer.getAge()<30) { rate *=0.8;
		}else if(targetCustomer.getAge()<40) { rate*=0.9;
		}else if(targetCustomer.getAge()<50) { rate*=1.2;
		}else if(targetCustomer.getAge()<60) { rate*=1.4;
		}else if(targetCustomer.getAge()<70) { rate *=1.6;
		}else {rate*=1.7;}
		return rate;
	}
}