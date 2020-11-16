package model.insurance;

import java.util.ArrayList;
import java.util.List;

import control.insurance.Insurance;
import model.Dao;

public class InsuranceDaoImpl extends Dao implements InsuranceDao{
	public InsuranceDaoImpl() {super();}
	
	public void insert(Insurance insurance) {
		try {
			String query = "insert into contractCondition (guaranteeAmount, insurancePeriod, payment) values ("
					+ insurance.getContractCondition().getGuarantee()+","
					+ insurance.getContractCondition().getPeriod()+","
					+ insurance.getContractCondition().getPayment()+",);"
					;
			super.insert(query);
		} catch (Exception e) {
		}
		
	}

	public ArrayList<Insurance> select() {
		List<Insurance> list = session.selectList("Insurance.Select");
		return (ArrayList<Insurance>)list;
	}
}
