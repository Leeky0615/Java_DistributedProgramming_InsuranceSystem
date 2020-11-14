package control.insurance;

import constants.ControlConstants.EBuildingType;
import constants.ControlConstants.EInsuranceType;
import control.customer.Customer;

public class FireInsurance extends Insurance {

	private int age;
	private int area;
	private String contractor;
	private int unitPrice;
	private EBuildingType buildingType;
	
	public FireInsurance(){
		super();
		this.insuranceType = EInsuranceType.FIRE;
	}

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
	
	public float calculateRate(Customer targetCustomer) {
		float rate =0;
//		if(targetCustomer.getProperty() != null) {rate*=1.2;}
//		else {rate*=1.1;}
		return rate;
	}
}