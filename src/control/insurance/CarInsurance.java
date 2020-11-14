package control.insurance;

import constants.ControlConstants.ECarType;
import constants.ControlConstants.EInsuranceType;
import control.customer.Customer;

public class CarInsurance extends Insurance {
	
	private boolean carAccidentHistory;
	private int carNum;
	private ECarType carType;
	private int Age;
	
	private String damage;
	private String driver;
	private int numOfPassengers;

	public CarInsurance(){
		super();
		this.insuranceType = EInsuranceType.CAR;
	}
	
	public int getAge() {return Age;}
	public void setAge(int age) {Age = age;}
	public boolean getCarAccidentHistory() {return carAccidentHistory;}
	public void setCarAccidentHistory(boolean carAccidentHistory) {this.carAccidentHistory = carAccidentHistory;}
	public int getCarNum() {return carNum;}
	public void setCarNum(int carNum) {this.carNum = carNum;}
	public ECarType getCarType() {return carType;}
	public void setCarType(ECarType carType) {this.carType = carType;}
	public String getDamage() {return damage;}
	public void setDamage(String damage) {this.damage = damage;}
	public String getDriver() {return driver;}
	public void setDriver(String driver) {this.driver = driver;}
	public int getNumOfPassengers() {return numOfPassengers;}
	public void setNumOfPassengers(int numOfPassengers) {this.numOfPassengers = numOfPassengers;}
	
	public float calculateRate(Customer targetCustomer) {
		float rate = 0;
		if(targetCustomer.getAge()<10) {rate*=0.5;}
		else if(targetCustomer.getAge()<20) {rate*=0.7;}
		else if(targetCustomer.getAge()<30) {rate *=0.8;}
		else if(targetCustomer.getAge()<40) {rate*=0.9;}
		else if(targetCustomer.getAge()<50) {rate*=1.2;}
		else if(targetCustomer.getAge()<60) {rate*=1.4;}
		else if(targetCustomer.getAge()<70) {rate *=1.6;}
		else {rate*=1.7;}
		return rate;
	}
}