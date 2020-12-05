package model.dto;

import constants.ControlConstants.EBuildingType;
import constants.ControlConstants.EPaymentMethod;

public class FireInsurance extends Insurance{

	private int age;
	private int area;
	private String contractor;
	private int unitPrice;
	private EBuildingType buildingType;
	
	private int paymentDate;
	private EPaymentMethod paymentMethod;
	private int insuranceId;
	private int customerId;
	
	public FireInsurance(){}

	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	public int getArea() {return area;}
	public void setArea(int area) {this.area = area;}
	public String getContractor() {return contractor;}
	public void setContractor(String contractor) {this.contractor = contractor;}
	public int getUnitPrice() {return unitPrice;}
	public void setUnitPrice(int unitPrice) {this.unitPrice = unitPrice;}
	public EBuildingType getBuildingType() {return buildingType;}
	public void setBuildingType(EBuildingType buildingType) {this.buildingType = buildingType;}
	
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
//		if(targetCustomer.getProperty() != null) {rate*=1.2;}
//		else {rate*=1.1;}
		return rate;
	}
}