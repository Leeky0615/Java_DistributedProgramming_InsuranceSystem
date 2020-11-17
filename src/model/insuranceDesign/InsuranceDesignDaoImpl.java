package model.insuranceDesign;

import java.util.ArrayList;
import java.util.List;

import constants.ViewConstants.EApprovalStatus;
import control.insurance.ContractCondition;
import control.insurance.Insurance;
import control.insuranceDevelopment.InsuranceDesign;
import model.Dao;

public class InsuranceDesignDaoImpl extends Dao implements InsuranceDesignDao{
	public InsuranceDesignDaoImpl() {super();}
	
	/*  super클래스(Dao클래스)에서 선언한 session(인스턴스변수)의 
	 *  함수 selectList()를 사용 -> 테이블에 있는 모든 값을 list에 담음
	 *  selectList()에 있는 파라미터는 mapper.xml파일에서 
	 *  미리 정해둔 Select태그를 이용 -> mapper이름+사용할 태그이름
	 */
	public ArrayList<InsuranceDesign> select() {
		List<InsuranceDesign> list = session.selectList("InsuranceDesign.Select");
		return (ArrayList<InsuranceDesign>)list;
	}
	
	/*
	 *  super클래스(Dao클래스)의 insert()함수 호출
	 *  -> 파라미터로 객체의 이름과 객체를 보냄.
	 */
	public void insert(InsuranceDesign insuranceDesign) {
		Insurance insurance = insuranceDesign.getInsurance();
		ContractCondition contractCondition = insurance.getContractCondition();
		
		super.insert(contractCondition.getClass().getSimpleName(), contractCondition);
		super.insert(insurance.getClass().getSimpleName(), insurance);
		super.insert(insuranceDesign.getClass().getSimpleName(), insuranceDesign);
	}

	public void delete(int insuranceDesignId) {
		super.update(Insurance.class.getSimpleName(), insuranceDesignId*10);
		super.update(ContractCondition.class.getSimpleName(), insuranceDesignId*10);
	}
// -------------------------------------------------------------------------
// 이거만남음.....
	
	public void update(InsuranceDesign insuranceDesign) {
		super.update(insuranceDesign.getClass().getSimpleName(), insuranceDesign);
		if (insuranceDesign.getApprovalStatus() == EApprovalStatus.ApprovalIns) {
			Insurance insurance = insuranceDesign.getInsurance();
			ContractCondition contractCondition = insurance.getContractCondition();
			
			super.update(insurance.getClass().getSimpleName(), insurance);
			super.update(contractCondition.getClass().getSimpleName(), contractCondition);
		}

//		try {
//			StringBuilder sb1 = new StringBuilder();
//
//			int eNum = status.ordinal() +1;
//			sb1.append("UPDATE `insurance`.`insurancedesign` SET `approvalStatus` = '");
//			sb1.append(eNum+"' WHERE (`insurancedesignID` = '");
//			sb1.append(insuranceDesignId+"');");
//			super.insert(sb1.toString());
//			if (status == EApprovalStatus.ApprovalIns) {
//				StringBuilder sb2 = new StringBuilder();
//				sb2.append("UPDATE insurance SET `insuranceid` = '");
//				sb2.append(insuranceId+"' WHERE (`insuranceid` = '");
//				sb2.append(insuranceDesignId*10+"');");
//				super.insert(sb2.toString());
//				
//				StringBuilder sb3 = new StringBuilder();
//				sb3.append("UPDATE contractcondition SET `contractconditionid` = '");
//				sb3.append(insuranceId+"' WHERE (`contractconditionid` = '");
//				sb3.append(insuranceDesignId*10+"');");
//				super.insert(sb3.toString());
//			}
//		} catch (Exception e) {e.getStackTrace();}
	}
	
	
}
