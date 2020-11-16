package model.insuranceRegistration;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import constants.ControlConstants.EInsuranceType;
import constants.ViewConstants.EApprovalStatus;
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
		ArrayList<InsuranceDesign> insuranceDesignList = new ArrayList<InsuranceDesign>();
		try {
			String query = "SELECT * FROM insurancedesign, insurance, contractcondition"
					+ " WHERE insurancedesign.insurance_id = insurance.insuranceid"
					+ " AND insurance.contractcondition_id = contractcondition.contractconditionid;";
			ResultSet rs = this.select(query);
			while(rs.next()) {
				InsuranceDesign insuranceDesign = new InsuranceDesign();
				switch (rs.getString("insuranceType")) {
				case"CANCER":insuranceDesign.setInsurance(new CancerInsurance());break;
				case"FIRE":insuranceDesign.setInsurance(new FireInsurance());break;
				case"CAR":insuranceDesign.setInsurance(new CarInsurance());break;
				default:break;
				}
				insuranceDesign.setInsuranceDesignId(rs.getInt("insurancedesignID"));
				insuranceDesign.setWriter(rs.getString("writer"));
				insuranceDesign.getInsurance().setInsuranceName(rs.getString("insuranceName"));
				insuranceDesign.getInsurance().setInsuranceId(rs.getInt("insurancedesign.insurance_id"));
				insuranceDesign.setMadeDate(rs.getString("madeDate"));
				insuranceDesign.getInsurance().getContractCondition().setContractConditionID(rs.getInt("insurance.contractcondition_id"));
				insuranceDesign.getInsurance().getContractCondition().setGuarantee(rs.getInt("guarantee"));
				insuranceDesign.getInsurance().getContractCondition().setPayment(rs.getInt("payment"));
				insuranceDesign.getInsurance().getContractCondition().setPeriod(rs.getInt("period"));
				switch (rs.getString("approvalStatus")) {
				case "RequestInsDesign":insuranceDesign.setApprovalStatus(EApprovalStatus.RequestInsDesign);break;
				case "Approvalns":insuranceDesign.setApprovalStatus(EApprovalStatus.ApprovalIns); break;
				case "DisApprovalIns":insuranceDesign.setApprovalStatus(EApprovalStatus.DisApprovalIns);break;
				default:break;
				}
				insuranceDesignList.add(insuranceDesign);
			}
			rs.close();
		} catch (Exception e) {e.printStackTrace();}
		return insuranceDesignList;
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
	public Insurance selectByCarInsurance(int id) {
		Insurance insurance = new CarInsurance();
//		try {
//			String query =  "SELECT * FROM carinsurance,insurance "
//					+ "WHERE carinsurance.insurance_id = insurance.insuranceid "
//					+ "AND carinsurance.customer_id ="+id+";";
//			ResultSet rs = this.select(query);
//			while(rs.next()) {
//				insurance.setInsuranceId(rs.getInt("insurance.insuranceid"));
//				insurance.setInsuranceName(rs.getString("insurancename"));
//				insurance.getContractCondition().setPaymentDate(rs.getInt("paymentdate"));
//				switch (rs.getString("paymentmethod")) {
//				case "CASH":insurance.getContractCondition().setPaymentType(EPaymentMethod.CASH);break; 
//				case "CARD":insurance.getContractCondition().setPaymentType(EPaymentMethod.CARD);break; 
//				case "ACCOUNT":insurance.getContractCondition().setPaymentType(EPaymentMethod.ACCOUNT);break; 
//				default:break;
//				}
//				switch (rs.getString("cartype")) {
//				case "SMALL":((CarInsurance)insurance).setCarType(ECarType.SMALL);break; 
//				case "MID":((CarInsurance)insurance).setCarType(ECarType.MID);break; 
//				case "LARGE":((CarInsurance)insurance).setCarType(ECarType.LARGE);break; 
//				case "MOTOR":((CarInsurance)insurance).setCarType(ECarType.MOTOR);break; 
//				default:break;
//				}
//				((CarInsurance)insurance).setCarNum(rs.getInt("carnum"));
//				((CarInsurance)insurance).setCarAccidentHistory(rs.getBoolean("caraccidenthistory"));
//				((CarInsurance)insurance).setAge(rs.getInt("age"));
//			}
//			rs.close();
//		} catch (Exception e) {e.getStackTrace();}
		return insurance;
	}
	public Insurance selectByFireInsurance(int id) {
		Insurance insurance = new FireInsurance();
//		try {
//			String query =  "SELECT * FROM fireinsurance,insurance "
//					+ "WHERE fireinsurance.insurance_id = insurance.insuranceid "
//					+ "AND fireinsurance.customer_id ="+id+";";
//			ResultSet rs = this.select(query);
//			while(rs.next()) {
//				insurance.setInsuranceId(rs.getInt("insurance.insuranceid"));
//				insurance.setInsuranceName(rs.getString("insurancename"));
//				insurance.getContractCondition().setPaymentDate(rs.getInt("paymentdate"));
//				switch (rs.getString("paymentmethod")) {
//				case "CASH":insurance.getContractCondition().setPaymentType(EPaymentMethod.CASH);break; 
//				case "CARD":insurance.getContractCondition().setPaymentType(EPaymentMethod.CARD);break; 
//				case "ACCOUNT":insurance.getContractCondition().setPaymentType(EPaymentMethod.ACCOUNT);break; 
//				default:break;
//				}
//				((FireInsurance)insurance).setArea(rs.getInt("area"));
//				switch (rs.getString("buildingtype")) {
//				case "Apartment":((FireInsurance)insurance).setBuildingType(EBuildingType.APARTMENT);break; 
//				case "Factory":((FireInsurance)insurance).setBuildingType(EBuildingType.FACTORY);break; 
//				case "House":((FireInsurance)insurance).setBuildingType(EBuildingType.HOUSE);break; 
//				case "WareHouse":((FireInsurance)insurance).setBuildingType(EBuildingType.WAREHOUSE);break; 
//				case "building":((FireInsurance)insurance).setBuildingType(EBuildingType.BUILDING);break; 
//				default:break;
//				}
//				((FireInsurance)insurance).setContractor(rs.getString("contractor"));
//				((FireInsurance)insurance).setAge(rs.getInt("age"));
//				((FireInsurance)insurance).setUnitPrice(rs.getInt("unitprice"));
//			}
//			rs.close();
//		} catch (Exception e) {e.getStackTrace();}
		return insurance;
	}
	public Insurance selectByCancerInsurance(int id) {
		Insurance insurance = new CancerInsurance();
//		try {
//			String query =  "SELECT * FROM cancerinsurance,insurance "
//					+ "WHERE cancerinsurance.insurance_id = insurance.insuranceid "
//					+ "AND cancerinsurance.customer_id ="+id+";";
//			ResultSet rs = this.select(query);
//			while(rs.next()) {
//				insurance.setInsuranceId(rs.getInt("insurance.insuranceid"));
//				insurance.setInsuranceName(rs.getString("insurancename"));
//				insurance.getContractCondition().setPaymentDate(rs.getInt("paymentdate"));
//				switch (rs.getString("paymentmethod")) {
//				case "CASH":insurance.getContractCondition().setPaymentType(EPaymentMethod.CASH);break; 
//				case "CARD":insurance.getContractCondition().setPaymentType(EPaymentMethod.CARD);break; 
//				case "ACCOUNT":insurance.getContractCondition().setPaymentType(EPaymentMethod.ACCOUNT);break; 
//				default:break;
//				}
//			}
//			rs.close();
//		} catch (Exception e) {e.getStackTrace();}
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
	
