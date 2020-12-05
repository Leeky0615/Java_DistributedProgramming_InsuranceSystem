package model.dto;

import constants.ViewConstants.EApprovalStatus;

public class InsuranceDesign {
	private int insuranceDesignId;
	
	private String writer;
	private String madeDate;
	private EApprovalStatus approvalStatus;
	private int insuranceId;
	
	private Insurance insurance;
	
	public InsuranceDesign(){}

	public int getInsuranceDesignId() {return insuranceDesignId;}
	public void setInsuranceDesignId(int insuranceDesignId) {this.insuranceDesignId = insuranceDesignId;}
	public String getWriter() {return writer;}
	public void setWriter(String writer) {this.writer = writer;}
	public String getMadeDate() {return madeDate;}
	public void setMadeDate(String madeDate) {this.madeDate = madeDate;}
	public EApprovalStatus getApprovalStatus() {return approvalStatus;}
	public void setApprovalStatus(EApprovalStatus approvalStatus) {this.approvalStatus = approvalStatus;}
	public int getInsuranceId() {return insuranceId;}
	public void setInsuranceId(int insuranceId) {this.insuranceId = insuranceId;}
	
	public Insurance getInsurance() {return insurance;}
	public void setInsurance(Insurance insurance) {this.insurance = insurance;}
}