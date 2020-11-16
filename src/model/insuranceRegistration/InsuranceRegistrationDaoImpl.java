package model.insuranceRegistration;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import constants.ControlConstants.EInsuranceType;
import control.customer.Customer;
import control.insurance.CancerInsurance;
import control.insurance.CarInsurance;
import control.insurance.FireInsurance;
import control.insurance.Insurance;
import control.insuranceDevelopment.InsuranceDesign;
import model.Dao;

public class InsuranceRegistrationDaoImpl extends Dao implements InsuranceRegistrationDao{
	public InsuranceRegistrationDaoImpl() {super();}
	public void insert(Customer customer, Insurance insuracne) {
		try {
			StringBuilder sb = new StringBuilder();
			switch (insuracne.getInsuranceType()) {
			case CAR :
				sb.append("INSERT INTO carinsurance (`id`, `age`, `driver`, `carnum`, `caraccidenthistory`, `cartype`, `paymentdate`, `paymentmethod`, `insurance_id`, `customer_id`) VALUES ('");
				sb.append(customer.getId()+"', '");
				sb.append(customer.getAge()+"', '");
				sb.append(customer.getName()+"', '");
				sb.append(((CarInsurance)insuracne).getCarNum()+"', '");
				if (((CarInsurance)insuracne).getCarAccidentHistory()) {sb.append(1+"', '");}
				else {sb.append(0+"', '");}
				sb.append(((CarInsurance)insuracne).getCarType().name()+"', '");
				sb.append(((CarInsurance)insuracne).getPaymentDate()+"', '");
				sb.append(((CarInsurance)insuracne).getPaymentMethod().name()+"', '");
				sb.append(insuracne.getInsuranceId()+"', '");
				sb.append(customer.getId()+"');");
				break;
			case FIRE:
				sb.append("INSERT INTO fireinsurance (`id`, `age`, `area`, `contractor`, `unitprice`, `buildingtype`, `paymentdate`, `paymentmethod`, `insurance_id`, `customer_id`) VALUES ('");
				sb.append(customer.getId()+"', '");
				sb.append(((FireInsurance)insuracne).getAge()+"', '");
				sb.append(((FireInsurance)insuracne).getArea()+"', '");
				sb.append(((FireInsurance)insuracne).getContractor()+"', '");
				sb.append(((FireInsurance)insuracne).getUnitPrice()+"', '");
				sb.append(((FireInsurance)insuracne).getBuildingType().name()+"', '");
				sb.append(((FireInsurance)insuracne).getPaymentDate()+"', '");
				sb.append(((FireInsurance)insuracne).getPaymentMethod().name()+"', '");
				sb.append(insuracne.getInsuranceId()+"', '");
				sb.append(customer.getId()+"');");
				break;
			case CANCER:
				sb.append("INSERT INTO cancerinsurance (`id`, `paymentdate`, `paymentmethod`, `insurance_id`, `customer_id`) VALUES ('");
				sb.append(customer.getId()+"', '");
				sb.append(((CancerInsurance)insuracne).getPaymentDate()+"', '");
				sb.append(((CancerInsurance)insuracne).getPaymentMethod().name()+"', '");
				sb.append(insuracne.getInsuranceId()+"', '");
				sb.append(customer.getId()+"');");
				System.out.println(sb.toString());
				break;
			default:break;
			}
			super.insert(sb.toString());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "�̹� ���Խ�û�Ǿ��ų� ���Ե� ���� ��ǰ�Դϴ�.", "�ߺ� ����", JOptionPane.WARNING_MESSAGE);
			return;
		}
	}

	public ArrayList<InsuranceDesign> select() {
		List<InsuranceDesign> list = session.selectList("Design.Select");
		return (ArrayList<InsuranceDesign>)list;
	}
	
	public void update(boolean status ,int customerId) {
		try {
			StringBuilder sb1 = new StringBuilder();
			sb1.append("UPDATE customer SET `registrationstatus` = '");
			if (status) {sb1.append(1+"' WHERE (`id` = '");}
			else {sb1.append(0+"' WHERE (`id` = '");}
			sb1.append(customerId+"');");
			super.update(sb1.toString());
		} catch (Exception e) {e.getStackTrace();}
	}
	public Insurance selectByCancerInsurance(int customerId) {
		Insurance insurance = new CancerInsurance();
		insurance = this.session.selectOne("Cancer.Select", customerId);
		return insurance;
	}
	public Insurance selectByCarInsurance(int customerId) {
		Insurance insurance = new CarInsurance();
		insurance = this.session.selectOne("Car.Select", customerId);
		return insurance;
	}
	public Insurance selectByFireInsurance(int customerId) {
		Insurance insurance = new FireInsurance();
		insurance = this.session.selectOne("Fire.Select", customerId);
		return insurance;
	}
	public void delete(EInsuranceType eInsuranceType, int customerId) {
		try {
			String query = "";
			if (eInsuranceType == EInsuranceType.CANCER) {
				query = "DELETE FROM cancerinsurance WHERE (`customer_id' = '"+customerId+"');";
			}else if(eInsuranceType == EInsuranceType.CAR) {
				query = "DELETE FROM carinsurance WHERE (`customer_id' = '"+customerId+"');";
			}else if(eInsuranceType == EInsuranceType.FIRE) {
				query = "DELETE FROM fireinsurance WHERE (`customer_id' = '"+customerId+"');";
			}
			super.delete(query);
		} catch (Exception e) {e.getStackTrace();}
	}
}
	
