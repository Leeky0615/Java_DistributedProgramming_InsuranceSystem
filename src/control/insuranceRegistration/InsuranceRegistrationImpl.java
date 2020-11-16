package control.insuranceRegistration;

import java.util.Vector;

import constants.ControlConstants.EBuildingType;
import constants.ControlConstants.ECarType;
import constants.ControlConstants.EInsuranceType;
import constants.ControlConstants.EPaymentMethod;
import control.customer.Customer;
import control.customer.CustomerListImpl;
import control.insurance.CancerInsurance;
import control.insurance.CarInsurance;
import control.insurance.FireInsurance;
import control.insurance.Insurance;
import control.insurance.InsuranceListImpl;
import control.salesPerson.SalesPersonListImpl;
import model.insuranceRegistration.InsuranceRegistrationDao;
import model.insuranceRegistration.InsuranceRegistrationDaoImpl;

public class InsuranceRegistrationImpl implements InsuranceRegistration {

	private Customer customer;
	private InsuranceListImpl insuranceList;
	private CustomerListImpl customerList;
	private SalesPersonListImpl salesPersonList;
	private InsuranceRegistrationDao insuranceRegistrationDao;
	
	public InsuranceRegistrationImpl(){
		this.insuranceRegistrationDao = new InsuranceRegistrationDaoImpl();
	}
	public void associate(InsuranceListImpl insuranceList, CustomerListImpl customerList, SalesPersonListImpl salesPersonList) {
		this.insuranceList = insuranceList;
		this.customerList = customerList;
		this.salesPersonList = salesPersonList;
	}
	
	public SalesPersonListImpl getSalesPersonList() {return salesPersonList;}
	public void setSalesPersonList(SalesPersonListImpl salesPersonList) {this.salesPersonList = salesPersonList;}
	public Customer getCustomer() {return customer;}
	public void setCustomer(Customer customer) {this.customer = customer;}
	public Insurance searchInsurance(int insuranceId) {return this.insuranceList.searchById(insuranceId);}
	public void approve(Customer customer){
		customer.setRegistrationStatus(false);
		this.insuranceRegistrationDao.update(false, customer.getId());
	}
	public void disApprove(EInsuranceType eInsuranceType, Customer customer) {
		customer.setRegistrationStatus(false);
		this.insuranceRegistrationDao.update(false, customer.getId());
		this.insuranceRegistrationDao.delete(eInsuranceType, customer.getId());
	}
	public void request(){
		customer.setRegistrationStatus(true);
		this.insuranceRegistrationDao.update(true, this.customer.getId());
	}
	
	public boolean writeCustomerInfomation(String customerName, String customerSID){
		for (Customer customer : this.customerList.getCustomerList()) {
			if (customer.getName().equals(customerName) && customer.getCustomerSID().equals(customerSID)) {
				this.setCustomer(customer);
				return true;
			}
		}
		return false;
	}
	public void writeInsuranceInformation(Insurance insurance, EInsuranceType type, Vector<Object> infos){
		if (type == EInsuranceType.CANCER) {
			CancerInsurance cancerInsurance = (CancerInsurance)insurance;
			cancerInsurance.setPaymentMethod((EPaymentMethod) infos.get(0));
			cancerInsurance.setPaymentDate((int) infos.get(1));
			this.insuranceRegistrationDao.insert(this.customer, cancerInsurance);
		}else if(type == EInsuranceType.CAR) {
			CarInsurance carInsurance = (CarInsurance)insurance;
			carInsurance.setPaymentMethod((EPaymentMethod) infos.get(0));
			carInsurance.setPaymentDate((int) infos.get(1));
			carInsurance.setCarNum((int) infos.get(2));
			carInsurance.setAge((int) infos.get(3));
			carInsurance.setCarType((ECarType) infos.get(4));
			carInsurance.setCarAccidentHistory((boolean) infos.get(5));
			carInsurance.setDriver(this.customer.getName());
			this.insuranceRegistrationDao.insert(this.customer, carInsurance);
		}else if(type == EInsuranceType.FIRE) {
			FireInsurance fireInsurance = (FireInsurance)insurance;
			fireInsurance.setPaymentMethod((EPaymentMethod) infos.get(0));
			fireInsurance.setPaymentDate((int) infos.get(1));
			fireInsurance.setArea((int) infos.get(2));
			fireInsurance.setAge((int) infos.get(3));
			fireInsurance.setBuildingType((EBuildingType) infos.get(4));
			fireInsurance.setUnitPrice((int) infos.get(5));
			fireInsurance.setContractor(this.customer.getName());
			this.insuranceRegistrationDao.insert(this.customer, fireInsurance);
		}
	}
	public Insurance getReadyInsurance(int id) {
		Insurance insurance = this.insuranceRegistrationDao.selectByCancerInsurance(id);
		if (insurance.getInsuranceId() != 0) {return insurance;}
		Insurance insurance1 = this.insuranceRegistrationDao.selectByCarInsurance(id);
		if (insurance1.getInsuranceId() != 0) {return insurance1;}
		Insurance insurance2 = this.insuranceRegistrationDao.selectByFireInsurance(id);
		if (insurance2.getInsuranceId() != 0) {return insurance2;}
		return null;
	}
}