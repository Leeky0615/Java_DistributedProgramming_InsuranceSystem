package control.accidentReciept;

import constants.ControlConstants.EInsuranceType;
import constants.ControlConstants.EPaymentMethod;

public class AccidentReceipt {

	private int accidentReceiptId;
	private String accidentReceiptName;
	private String customerName;
	private String customerId;
	private EInsuranceType insuranceType;
	private EPaymentMethod paymentMethod;
	private String accidentDate;
	private String hospitalName;
	private boolean deathStatus;
	private String accidentPlace;
	private String diagnosisName;
	private String damageScale;
	private String accidentCircumstances;
	private int money;
	private boolean paymentStatus;

	public AccidentReceipt(){}

	public String getAccidentReceiptName() {return accidentReceiptName;}
	public void setAccidentReceiptName(String accidentReceiptName) {this.accidentReceiptName = accidentReceiptName;}
	public int getAccidentReceiptId() {return accidentReceiptId;}
	public void setAccidentReceiptId(int accidentReceiptId) {this.accidentReceiptId = accidentReceiptId;}
	public String getCustomerName() {return customerName;}
	public void setCustomerName(String CustomerName) {this.customerName = CustomerName;}
	public String getCustomerId() {return customerId;}
	public void setCustomerId(String customerId) {this.customerId = customerId;}
	public EInsuranceType getInsuranceType() {return insuranceType;}
	public void setInsuranceType(EInsuranceType insuranceType) {this.insuranceType = insuranceType;}
	public EPaymentMethod getPaymentMethod() {return paymentMethod;}
	public void setPaymentMethod(EPaymentMethod paymentMethod) {this.paymentMethod = paymentMethod;}
	public String getAccidentDate() {return accidentDate;}
	public void setAccidentDate(String accidentDate) {this.accidentDate = accidentDate;}
	public String getHospitalName() {return hospitalName;}
	public void setHospitalName(String hospitalName) {this.hospitalName = hospitalName;}
	public boolean isDeathStatus() {return deathStatus;}
	public void setDeathStatus(boolean deathStatus) {this.deathStatus = deathStatus;}
	public String getAccidentPlace() {return accidentPlace;}
	public void setAccidentPlace(String accidentPlace) {this.accidentPlace = accidentPlace;}
	public String getDiagnosisName() {return diagnosisName;}
	public void setDiagnosisName(String diagnosisName) {this.diagnosisName = diagnosisName;}
	public String getDamageScale() {return damageScale;}
	public void setDamageScale(String damageScale) {this.damageScale = damageScale;}
	public String getAccidentCircumstances() {return accidentCircumstances;}
	public void setAccidentCircumstances(String accidentCircumstances) {this.accidentCircumstances = accidentCircumstances;}
	public boolean isPaymentStatus() {return paymentStatus;}
	public void setPaymentStatus(boolean paymentStatus) {this.paymentStatus = paymentStatus;}
	public int getMoney() {return money;}
	public void setMoney(int money) {this.money = money;}
}