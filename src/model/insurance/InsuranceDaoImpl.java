package model.insurance;

import java.sql.ResultSet;
import java.util.ArrayList;

import control.insurance.CancerInsurance;
import control.insurance.CarInsurance;
import control.insurance.FireInsurance;
import control.insurance.Insurance;
import model.Dao;

public class InsuranceDaoImpl extends Dao implements InsuranceDao{
	public InsuranceDaoImpl() {
		super();
	}
	public void insert(Insurance insurance) {
		try {
			String query = "insert into contractCondition (guaranteeAmount, insurancePeriod, payment) values ("
					+ insurance.getContractCondition().getGuarantee()+","
					+ insurance.getContractCondition().getPeriod()+","
					+ insurance.getContractCondition().getPayment()+",);"
					;
			super.insert(query);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public ArrayList<Insurance> select() {
		ArrayList<Insurance> insuranceList = new ArrayList<Insurance>();
		try {
			String query = "SELECT * FROM insurance, contractcondition"
					+ " WHERE insurance.contractcondition_id = contractcondition.contractconditionid"
					+ " AND insurance.contractcondition_id>=1000;";
			ResultSet rs = this.select(query);
			while(rs.next()) {
				Insurance insurance = null;
				switch (rs.getString("insuranceType")) {
				case"CANCER":insurance = new CancerInsurance();break;
				case"FIRE":insurance = new FireInsurance();break;
				case"CAR":insurance = new CarInsurance();break;
				default:break;
				}
				insurance.setInsuranceName(rs.getString("insurancename"));
				insurance.setInsuranceId(rs.getInt("insuranceid"));
				insurance.setInsuranceDescription(rs.getString("insurancedescription"));
				insurance.getContractCondition().setGuarantee(rs.getInt("guarantee"));
				insurance.getContractCondition().setPeriod(rs.getInt("period"));
				insurance.getContractCondition().setPayment(rs.getInt("payment"));
				insuranceList.add(insurance);
			}
			rs.close();
			System.out.println("sucess");
		} catch (Exception e) {e.printStackTrace();}
		return insuranceList;
	}

	public ArrayList<Insurance> selectCustomerInsurance(int customerId) {
		ArrayList<Insurance> insuranceList = new ArrayList<Insurance>();
		try {
			String query = "SELECT * FROM carinsurance WHERE customer_id ="+customerId+";";
			ResultSet rs = this.select(query);
			while(rs.next()) {
				Insurance insurance = null;
				switch (rs.getString("insuranceType")) {
				case"CANCER":insurance = new CancerInsurance();break;
				case"FIRE":insurance = new FireInsurance();break;
				case"CAR":insurance = new CarInsurance();break;
				default:break;
				}
				insurance.setInsuranceName(rs.getString("insurancename"));
				insurance.setInsuranceId(rs.getInt("insuranceid"));
				insurance.setInsuranceDescription(rs.getString("insurancedescription"));
				insurance.getContractCondition().setGuarantee(rs.getInt("guarantee"));
				insurance.getContractCondition().setPeriod(rs.getInt("period"));
				insurance.getContractCondition().setPayment(rs.getInt("payment"));
				insuranceList.add(insurance);
			}
			rs.close();
			System.out.println("sucess");
		} catch (Exception e) {e.printStackTrace();}
		return insuranceList;
	}

}
