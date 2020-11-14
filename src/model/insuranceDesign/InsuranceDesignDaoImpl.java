package model.insuranceDesign;

import java.sql.ResultSet;
import java.util.ArrayList;

import constants.ViewConstants.EApprovalStatus;
import control.insurance.CancerInsurance;
import control.insurance.CarInsurance;
import control.insurance.FireInsurance;
import control.insuranceDevelopment.InsuranceDesign;
import model.Dao;

public class InsuranceDesignDaoImpl extends Dao implements InsuranceDesignDao{
	public InsuranceDesignDaoImpl() {super();}
	
	public void insert(InsuranceDesign insuranceDesign) {
		try {
			StringBuilder sb1 = new StringBuilder();
			sb1.append("INSERT INTO contractcondition (`contractconditionid`, `guarantee`, `period`, `payment`) VALUES ('");
			sb1.append(insuranceDesign.getInsurance().getContractCondition().getContractConditionID()+"', '");
			sb1.append(insuranceDesign.getInsurance().getContractCondition().getGuarantee()+"', '");
			sb1.append(insuranceDesign.getInsurance().getContractCondition().getPeriod()+"', '");
			sb1.append(insuranceDesign.getInsurance().getContractCondition().getPayment()+"');");
			super.insert(sb1.toString());

			StringBuilder sb2 = new StringBuilder();
			sb2.append("INSERT INTO insurance (`insuranceid`, `insuranceType`,`insurancedescription`,`insurancename`, `contractcondition_id`) VALUES ('");
			sb2.append(insuranceDesign.getInsurance().getInsuranceId()+"', '");
			sb2.append(insuranceDesign.getInsurance().getInsuranceType()+"', '");
			sb2.append(insuranceDesign.getInsurance().getInsuranceDescription()+"', '");
			sb2.append(insuranceDesign.getInsurance().getInsuranceName()+"', '");
			sb2.append(insuranceDesign.getInsurance().getContractCondition().getContractConditionID()+"');");
			super.insert(sb2.toString());
			
			StringBuilder sb3 = new StringBuilder();
			sb3.append("INSERT INTO insurancedesign (`insurancedesignID`, `writer`, `madeDate`,`insurance_id`,`approvalStatus`) VALUES ('");
			sb3.append(insuranceDesign.getInsuranceDesignId()+"', '");
			sb3.append(insuranceDesign.getWriter()+"', '");
			sb3.append(insuranceDesign.getMadeDate()+"', '");
			sb3.append(insuranceDesign.getInsurance().getInsuranceId()+"', '");
			sb3.append("RequestInsDesign');");
			super.insert(sb3.toString());
		} catch (Exception e) {e.getStackTrace();}
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
	
	public void update(EApprovalStatus status ,int insuranceDesignId, int insuranceId) {
		try {
			StringBuilder sb1 = new StringBuilder();

			int eNum = status.ordinal() +1;
			sb1.append("UPDATE `insurance`.`insurancedesign` SET `approvalStatus` = '");
			sb1.append(eNum+"' WHERE (`insurancedesignID` = '");
			sb1.append(insuranceDesignId+"');");
			super.insert(sb1.toString());
			if (status == EApprovalStatus.ApprovalIns) {
				StringBuilder sb2 = new StringBuilder();
				sb2.append("UPDATE insurance SET `insuranceid` = '");
				sb2.append(insuranceId+"' WHERE (`insuranceid` = '");
				sb2.append(insuranceDesignId*10+"');");
				super.insert(sb2.toString());
				
				StringBuilder sb3 = new StringBuilder();
				sb3.append("UPDATE contractcondition SET `contractconditionid` = '");
				sb3.append(insuranceId+"' WHERE (`contractconditionid` = '");
				sb3.append(insuranceDesignId*10+"');");
				super.insert(sb3.toString());
			}
		} catch (Exception e) {e.getStackTrace();}
	}
	public void delete(int insuranceDesignId) {
		try {
			String query = "DELETE FROM insurance WHERE (`insuranceid` = '"+insuranceDesignId*10+"');";
			String query1 = "DELETE FROM contractcondition WHERE (`contractconditionid` = '"+insuranceDesignId*10+"');";
			super.delete(query);
			super.delete(query1);
		} catch (Exception e) {e.getStackTrace();}
	}

}
