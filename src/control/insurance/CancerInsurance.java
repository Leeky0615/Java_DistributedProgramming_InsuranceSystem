package control.insurance;

import constants.ControlConstants.EInsuranceType;
import control.customer.Customer;

public class CancerInsurance extends Insurance {

	private int anticancerTreatmentCost;
	private boolean caregiverStatus;
	private int diagnosisExpense;
	private int hospitalizationFee;
	private float incidenceProbability;
	private int payRenewalStatus;
	private int surgeryExpenseStatus;
	private String cancerType;
	
	public CancerInsurance(){
		super();
		this.insuranceType = EInsuranceType.CANCER;
	}

	public int getAnticancerTreatmentCost() {return anticancerTreatmentCost;}
	public void setAnticancerTreatmentCost(int anticancerTreatmentCost) {this.anticancerTreatmentCost = anticancerTreatmentCost;}
	public boolean isCaregiverStatus() {return caregiverStatus;}
	public void setCaregiverStatus(boolean caregiverStatus) {this.caregiverStatus = caregiverStatus;}
	public int getDiagnosisExpense() {return diagnosisExpense;}
	public void setDiagnosisExpense(int diagnosisExpense) {this.diagnosisExpense = diagnosisExpense;}
	public int getHospitalizationFee() {return hospitalizationFee;}
	public void setHospitalizationFee(int hospitalizationFee) {this.hospitalizationFee = hospitalizationFee;}
	public float getIncidenceProbability() {return incidenceProbability;}
	public void setIncidenceProbability(float incidenceProbability) {this.incidenceProbability = incidenceProbability;}
	public int getPayRenewalStatus() {return payRenewalStatus;}
	public void setPayRenewalStatus(int payRenewalStatus) {this.payRenewalStatus = payRenewalStatus;}
	public int getSurgeryExpenseStatus() {return surgeryExpenseStatus;}
	public void setSurgeryExpenseStatus(int surgeryExpenseStatus) {this.surgeryExpenseStatus = surgeryExpenseStatus;}
	public String getCancerType() {return cancerType;}
	public void setCancerType(String cancerType) {this.cancerType = cancerType;}
	
	public float calculateRate(Customer targetCustomer) {
		float rate =0;
		
		if(targetCustomer.isGender().equals("¿©¼º")) {rate*=0.9;}
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