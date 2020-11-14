package control.insuranceDevelopment;

import constants.ViewConstants.EApprovalStatus;
import control.insurance.Insurance;

public class InsuranceDesign {
	private Insurance insurance;
	private int insuranceDesignId;
	private int insuranceid;
	
	private String writer;
	private String madeDate;
	private EApprovalStatus approvalStatus;
	
	public InsuranceDesign(){}

	public EApprovalStatus getApprovalStatus() {return approvalStatus;}
	
	public int getInsuranceid() {return insuranceid;}
	public void setInsuranceid(int insuranceid) {this.insuranceid = insuranceid;}
	public void setApprovalStatus(EApprovalStatus approvalStatus) {this.approvalStatus = approvalStatus;}
	public int getInsuranceDesignId() {return insuranceDesignId;}
	public void setInsuranceDesignId(int insuranceDesignId) {this.insuranceDesignId = insuranceDesignId;}
	public Insurance getInsurance() {return insurance;}
	public void setInsurance(Insurance insurance) {this.insurance = insurance;}
	public String getMadeDate() {return madeDate;}
	public void setMadeDate(String madeDate) {this.madeDate = madeDate;}
	public String getWriter() {return writer;}
	public void setWriter(String writer) {this.writer = writer;}
}